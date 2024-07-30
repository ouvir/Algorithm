import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
graph = [list(map(int, input().rstrip())) for _ in range(N)]
visited = [ [False] * (N) for _ in range(N)]
min_remove_count = int(1e9)

dx = [1,0,-1,0]
dy = [0,1,0,-1]

q = deque()
q.append((0,0,0))
visited[0][0] = True

while q:
    x, y, r = q.popleft()

    if x == N - 1 and y == N - 1:
        min_remove_count = r if r < min_remove_count else min_remove_count
        continue

    for i in range(4):
        cx , cy = x + dx[i], y + dy[i]
        if cx < 0 or cx >= N or cy < 0 or cy >= N:
            continue
        if visited[cx][cy]:
            continue
        if graph[cx][cy] == 0:
            visited[cx][cy] = True
            q.append((cx,cy,r+1))
        else:
            visited[cx][cy] = True
            q.appendleft((cx,cy,r))
print(min_remove_count)