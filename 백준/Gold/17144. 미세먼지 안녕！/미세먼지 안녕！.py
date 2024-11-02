# T초 반복
# 1초당 미세먼지 확산, 공기청정기 작동 진행
# 0~공청기 윗부분 -> 반시계 방향 순환
# 0~공청기 아랫부분 -> 시계방향 순환
# 미세먼지 확산 -> BFS

import sys
import copy
from collections import deque

input = sys.stdin.readline
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


R,C,T = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(R)]

top = 0
for i in range(R):
    if graph[i][0] == -1:
        top = i
        break
bottom = top + 1
        
def move(graph): # 먼지 확산: 시간복잡도 O(RC)
    tmp = copy.deepcopy(graph)
    q = deque()
    
    for i in range(R):
        for j in range(C):
            if graph[i][j] > 0:
                q.append((i,j))
    
    while q:
        x, y = q.popleft()
        
        count = 0
        for i in range(4):
            cx, cy = x + dx[i], y + dy[i]
            if cx >= R or cx < 0 or cy >= C or cy < 0:
                continue
            if graph[cx][cy] == -1:
                continue
            count += 1
            tmp[cx][cy] += graph[x][y] // 5
        tmp[x][y] -= count * (graph[x][y] // 5)
    return tmp

def operate_clean(graph, top, bottom): #공기청정기 작동
    # 위쪽 반시계 방향 회전
    for i in range(1, top):  
        graph[top-i][0] = graph[top-(i+1)][0]
    for i in range(0, C - 1):
        graph[0][i] = graph[0][i+1]
    for i in range(0, top):
        graph[i][C-1] = graph[i+1][C-1]
    for i in range(C-1, 1, -1):
        graph[top][i] = graph[top][i-1]
    graph[top][1] = 0 #먼지 없는 공기 배출
    
    # 아래쪽 시계 방향 회전
    for i in range(bottom + 1, R - 1):  
        graph[i][0] = graph[i+1][0]
    for i in range(0, C - 1):
        graph[R-1][i] = graph[R-1][i+1]
    for i in range(R - 1, bottom, -1):
        graph[i][C-1] = graph[i-1][C-1]
    for i in range(C-1, 1, -1):
        graph[bottom][i] = graph[bottom][i-1]
    graph[bottom][1] = 0 #먼지 없는 공기 배출
     
        
        
for time in range(T):
    graph = move(graph)
    operate_clean(graph, top, bottom)

output = 2

for i in range(R):
    for j in range(C):
        output += graph[i][j]
print(output)