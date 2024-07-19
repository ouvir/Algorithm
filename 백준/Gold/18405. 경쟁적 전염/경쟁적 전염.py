import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int,input().split())))

S, X, Y = map(int,input().split())

virus = []

for i in range(N):
    for j in range(N):
        if graph[i][j] != 0:
            virus.append((graph[i][j],i,j))

dx = [1,0,-1,0]
dy = [0,1,0,-1]

virus.sort()

q = deque()

for v,x,y in virus:
    q.append((v,x,y,0)) # 바이러스번호, x,y,시간

while q:
    now = q.popleft()

    if now[3] == S:
        break
    
    for i in range(4):
        cx, cy = dx[i] + now[1], dy[i] + now[2]

        if cx < 0 or cx >= N or cy < 0 or cy >= N:
            continue
        if graph[cx][cy] != 0:
            continue
        else:
            graph[cx][cy] = now[0]
            q.append((now[0], cx, cy, now[3] + 1))

print(graph[X-1][Y-1])