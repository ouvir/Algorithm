import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().rstrip())))

dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs(x,y):
    queue = deque()
    queue.append((x,y))

    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx, ny = cx + dx[i], cy + dy[i]
            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:
                queue.append((nx,ny))
                graph[nx][ny] = graph[cx][cy] + 1

    return graph[-1][-1]

print(bfs(0,0))