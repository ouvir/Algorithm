import sys
from itertools import combinations

input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

output = INF
house = []
chicken_house = []

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            house.append((i, j))
        elif graph[i][j] == 2:
            chicken_house.append((i, j))

# 치킨집 중 M개 뽑아서 리스트로 반환
for chick_m_list in combinations(chicken_house, M):
    total_chicken_distance = 0
    for h in house:
        h_chicken_distance = INF
        # 모든 치킨 집 중 가장 가까운 거리 찾기
        for j in range(M):
            distance = abs(h[0] - chick_m_list[j][0]) + abs(h[1] - chick_m_list[j][1])
            h_chicken_distance = min(h_chicken_distance, distance)
        total_chicken_distance += h_chicken_distance
    output = min(output, total_chicken_distance)

print(output)