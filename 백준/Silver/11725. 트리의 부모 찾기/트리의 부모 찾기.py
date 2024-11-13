# 탐색으로 찾기 1부터 탐색하며, 부모 찾기
from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
parent = [i for i in range(N + 1)]
visited = [False for i in range(N + 1)]
graph = [list() for _ in range(N+1)]

for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(start):
    parent[start] = 1
    visited[start] = True
    q = deque()
    q.append(1)

    while q:
        now = q.popleft()
        for u in graph[now]:
            if not visited[u]:
                visited[u] = True
                parent[u] = now
                q.append(u)
bfs(1)

for i in range(2, N+1):
    print(parent[i])