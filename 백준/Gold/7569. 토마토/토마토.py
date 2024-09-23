import sys
from collections import deque

input = sys.stdin.readline

M, N, H = map(int, input().split())

graph = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

q = deque()

for h in range(H):
    for n in range(N):
        for m in range(M):
            if graph[h][n][m] == 1:
                q.append((h,n,m))

dm = [1, -1, 0, 0, 0, 0]
dn = [0, 0, 1, -1, 0, 0]
dh = [0, 0, 0, 0, 1, -1]

def BFS():
    while q:
        h, n, m = q.popleft()
        
        for i in range(6):
            ch = dh[i] + h
            cn = dn[i] + n
            cm = dm[i] + m
            if ch >= H or ch < 0 or cn >= N or cn < 0 or cm >= M or cm < 0:
                continue
            if graph[ch][cn][cm] == 0:
                graph[ch][cn][cm] = graph[h][n][m] + 1
                q.append((ch,cn,cm))

BFS()

day = 0

for h in range(H):
    for n in range(N):
        for m in range(M):
            if graph[h][n][m] == 0:
                print(-1)
                exit(0)
            day = max(day, graph[h][n][m])

print(day - 1)