import sys
from collections import deque

input = sys.stdin.readline

def bfs(graph, visited):
    count = 0
    q = deque()
    q.append(1)
    visited[1] = True

    while q:
        now = q.popleft()

        for e in graph[now]:
            if not visited[e]:
                q.append(e)
                count += 1
                visited[e] = True

    return count

N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]
visited = [False] * (N+1)

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

print(bfs(graph, visited))