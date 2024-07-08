import sys
from collections import deque
from collections import defaultdict

N, M, start = map(int, sys.stdin.readline().split())

graph = defaultdict(list)
visited = [0 for _ in range(N+1)]

for _ in range(M):
    v1, v2 = map(int, sys.stdin.readline().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

# 정렬
for key in graph.keys():
    graph[key].sort()

def dfs(start):
    visited[start] = 1
    print(start, end=" ")

    for v in graph[start]:
        if visited[v] == 0:
            dfs(v)

def bfs(start):
    visited[start] = 1
    queue = deque()
    queue.append(start)
    print(start, end=" ")

    while queue:
        v = queue.popleft()
        for u in graph[v]:
            if visited[u] == 0:
                visited[u] = 1
                queue.append(u)
                print(u,end=" ")


dfs(start)
print()
visited = [0 for _ in range(N+1)]
bfs(start)