import sys
from collections import deque

input = sys.stdin.readline

M, N = map(int,input().split())

graph = []
visited = []
for i in range(N):
    graph.append(list(map(int, input().rstrip())))
    visited.append([False for _ in range(M)])

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

q = deque()
q.append((0,0,0)) # x,y, block
visited[0][0] = True

result = 100000
while q:
    x, y, b = q.popleft()

    if x == N - 1 and y == M - 1:
        result = b
        break

    for i in range(4):
        cx, cy = dx[i] + x, dy[i] + y
        if cx < 0 or cx >= N or cy < 0 or cy >= M:
            continue
        if not visited[cx][cy]:
            visited[cx][cy] = True
            if graph[cx][cy]:
                q.append((cx, cy, b + graph[cx][cy]))
            else:
                q.appendleft((cx, cy, b + graph[cx][cy]))

print(result)