# 필요한 감독관의 수 구하기
# N 시험장의 개수, Ai 각 시험장의 응시자 수
# B 총감독관 감시 가능 수, C 부감독관의 감시 가능 수
# 총 감독관 개수 세기 O(N)
# 부 감독관 개수 세기 O(N)

import sys
input = sys.stdin.readline

N = int(input())
graph = list(map(int, input().split()))
B, C = map(int, input().split())

need_people = 0

for i in range(N):
    need_people += 1 # 총 감독관 추가
    graph[i] -= B
    if graph[i] <= 0:
        continue
    # 부 감독관 추가
    if graph[i] % C == 0:
        need_people += graph[i] // C
    else:
        need_people += (graph[i] // C) + 1

print(need_people)