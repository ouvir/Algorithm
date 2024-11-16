# 100칸의 그래프
# 최소 번수 -> BFS
# 만약 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다.
# 사다리와 뱀 주어짐 N,M 개씩

from collections import deque
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

visited = [False] * 101

up = dict()
down = dict()

for _ in range(N):
    x, y = map(int, input().split())
    up[x] = y

for _ in range(M):
    u, v = map(int, input().split())
    down[u] = v


def bfs(start):
    q = deque()
    q.append((start, 0))
    visited[start] = True

    while q:
        now, c = q.popleft()
        if now == 100:
            return c

        for i in range(1, 7):
            if now + i > 100:
                continue
            if visited[now + i]:
                continue
            if now + i in up:
                visited[up[now + i]] = True
                q.append((up[now + i], c + 1))
            elif now + i in down:
                visited[down[now + i]] = True
                q.append((down[now + i], c + 1))
            else:
                visited[now + i] = True
                q.append((now + i, c + 1))

count = bfs(1)

print(count)