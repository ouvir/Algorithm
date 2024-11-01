# 높이 1 씩 증가시켜가며 계속 탐색
# 탈출: (가장 큰 기둥 위치 == 가장 작은 기둥 위치)
# 높이가 n 이상인 위치가 (가장 큰 기둥 - 가장 작은 기둥 위치 + 1 값) 을 더해주기
# 이를 반복하며 탐색

import sys

input = sys.stdin.readline

N = int(input())
graph = []

for _ in range(N):
    L, H = map(int,input().split())
    graph.append((L,H))

graph.sort() # 위치 기준 정렬

height = 1
start_idx = 0
end_idx = N - 1

output = 0
while True:
    if start_idx > end_idx:
        break
    
    if graph[start_idx][1] < height:
        start_idx += 1
        continue
    if graph[end_idx][1] < height:
        end_idx -= 1
        continue
    output += (graph[end_idx][0] - graph[start_idx][0] + 1)
    height += 1
print(output)