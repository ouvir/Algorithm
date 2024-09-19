import sys
from collections import deque

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
indegree = [0] * (N+1)

for _ in range(M):
    data = list(map(int, input().split()))
    for i in range(1, data[0]):
        graph[data[i]].append(data[i+1])
        indegree[data[i+1]] += 1
def topology_sort():
    output = []
    q = deque()
    
    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()
        output.append(now)
        for e in graph[now]:
            indegree[e] -= 1
            if indegree[e] == 0:
                q.append(e)
    
    if len(output) != N:
        print(0)
    else:
        print(*output, sep='\n')
        
topology_sort()