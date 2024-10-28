# 위치 기준 정렬 > O(NlogN)
# (다음 기둥 위치 - 현재 기둥 위치) * 현재 기둥 높이 = 면적
# 가장 큰 기둥 기준 -> 왼쪽 오른쪽은 계속 감소하는 형태
# 만약 오른쪽으로 진행하며, 
# 감소가 아니라 커진 형태라면, 기존 기둥은 안쓰인다고 보면 됨

import sys

input = sys.stdin.readline

N = int(input())
graph = []

for _ in range(N):
    L, H = map(int, input().split())
    graph.append((L,H))

graph.sort()

max_index = 0
max_value = 0
for i in range(N):
    if max_value < graph[i][1]:
        max_value = graph[i][1]
        max_index = i

output = 0
h = graph[0][1]

for i in range(max_index):
    if graph[i+1][1] > h:
        output += (graph[i+1][0] - graph[i][0]) * h
        h = graph[i+1][1]
    else:
        output += (graph[i+1][0] - graph[i][0]) * h
    
output += graph[max_index][1]

h = graph[N-1][1]
for i in range(N-1, max_index, -1):
    if graph[i-1][1] > h:
        output += (graph[i][0] - graph[i-1][0]) * h
        h = graph[i-1][1]
    else:
        output += (graph[i][0] - graph[i-1][0]) * h
    
print(output)