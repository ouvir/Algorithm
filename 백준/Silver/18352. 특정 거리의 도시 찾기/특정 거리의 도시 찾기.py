import sys
from collections import deque

input = sys.stdin.readline

N, M, K, X = map(int,input().split())

graph = [[] for _ in range(N+1)]

visited = [False] * (N+1)

for _ in range(M):
    a, b = map(int,input().split())
    graph[a].append(b)

def dijkstra(graph, start, visited, K):
    output = []
    q = deque()
    q.append((start,0))
    visited[start] = True

    while q:
        now, d = q.popleft()
        if d == K:
            output.append(now)
        
        for e in graph[now]:
            if not visited[e]:
                visited[e] = True
                q.append((e,d+1))

    return output

output = dijkstra(graph, X, visited, K)

output.sort()

if len(output) == 0:
    print(-1)
else:
    for n in output:
        print(n)