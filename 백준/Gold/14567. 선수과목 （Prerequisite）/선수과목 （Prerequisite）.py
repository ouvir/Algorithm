import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for i in range(N+1)]
indegree = [0] * (N+1)
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    indegree[b] += 1

count = 1
output = [0] * (N+1)

q = deque()

for i in range(1,N+1):
    if indegree[i] == 0:
        q.append((i, count))

while q:
    now, d = q.popleft()
    output[now] = d

    for e in graph[now]:
        indegree[e] -= 1
        if indegree[e] == 0:
            q.append((e, d + 1))

print(*output[1:])