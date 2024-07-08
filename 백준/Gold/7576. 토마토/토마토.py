import sys
from collections import deque

M, N = map(int,sys.stdin.readline().split())

box = []
for _ in range(N):
    box.append(list(map(int, sys.stdin.readline().split())))

dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs(box):
    queue = deque()

    for i in range(N):
        for j in range(M):
            if box[i][j] == 1:
                queue.append((i,j,0))

    output_time = 0

    while queue:
        cx, cy, time = queue.popleft()
        
        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if box[nx][ny] == 1 or box[nx][ny] == -1:
                continue
            queue.append((nx,ny,time + 1))
            box[nx][ny] = 1
            output_time = max(output_time, time + 1)
    
    for line in box:
        if 0 in line:
            return -1
        
    return output_time

print(bfs(box))