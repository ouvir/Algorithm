from collections import deque
import sys
input = sys.stdin.readline

dx = [0, 1, 1, 1]
dy = [0, -1, 0, 1]

N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]
# graph[N][M]

q = deque()

for i in range(M):
    q.append((0, i, 0, graph[0][i])) # x,y,d,t

output = int(1e9)

while q:
    x, y, d, t = q.popleft()
    if x == N - 1:
        output = min(output, t)
        continue

    for i in range(1, 4):
        if i == d: # 같은 방향 제외
            continue
        cx, cy = dx[i] + x, dy[i] + y
        if cx >= N or cx < 0 or cy >= M or cy < 0:
            continue
        q.append((cx, cy, i, t + graph[cx][cy]))

print(output)