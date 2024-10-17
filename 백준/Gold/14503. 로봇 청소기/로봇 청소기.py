# 구현 - 시뮬레이션
# 1. 현재칸 청소
# 2. 4칸중 청소 안된 칸 없는경우
# 2-1. 바라보는 방향 유지 후진
# 2-2. 후진 못하면 작동 중지
# 3. 4칸 중 청소 안된 빈칸 있음
# 3-1. 반시계 방향 90 회전(방향 전환)
# 3-2. 청소 안된 칸이 앞칸이면 전진
# graph[][] = 1 (벽), 0 (청소 안함) , -1 (청소 함)

import sys
from collections import deque
input = sys.stdin.readline
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]


N, M = map(int, input().split())
R, C, D = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

def bfs(graph, status):
    q = deque()
    q.append(status)
    
    clean_count = 0
    
    while q:
        x, y, d = q.popleft()
        
        if graph[x][y] == 0:
            graph[x][y] = -1
            clean_count += 1
        
        all_clean = True
        for i in range(4):
            cx, cy = x + dx[i], y + dy[i]
            if cx >= N or cx < 0 or cy >= M or cy < 0:
                continue
            if graph[cx][cy] == 0:
                all_clean = False
        
        if all_clean:
            back_d = (d + 2) % 4
            cx, cy = x + dx[back_d], y + dy[back_d]
            if cx >= N or cx < 0 or cy >= M or cy < 0:
                break
            if graph[cx][cy] == 1:
                break
            q.append((cx, cy, d))
        else:
            for _ in range(4):
                d = (d + 3) % 4 # 반시계 방향 전환
                cx, cy = x + dx[d], y + dy[d]
                if cx >= N or cx < 0 or cy >= M or cy < 0:
                    continue
                if graph[cx][cy] == 0:
                    q.append((cx, cy, d))
                    break
    return clean_count 
            
result = bfs(graph, (R, C, D))

print(result)