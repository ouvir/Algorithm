import sys
from collections import deque

input = sys.stdin.readline

tc = int(input())

def topology_sort(graph, indegree):
    output = []
    q = deque()
    
    for i in range(1,len(indegree)):
        if indegree[i] == 0:
            q.append(i)
    
    while q:
        if len(q) >= 2:
            return ['IMPOSSIBLE']
        
        now = q.popleft()
        output.append(now)

        for e in graph[now]:
            indegree[e] -= 1
            if indegree[e] == 0:
                q.append(e)

    if len(output) + 1 != len(indegree):
        return ['IMPOSSIBLE']
    
    return output

for _ in range(tc):
    N = int(input())
    team = list(map(int, input().split()))
    graph = [set() for i in range(N+1)]
    indegree = [0] * (N+1)
    for i in range(N):
        for j in range(i+1, N):
            graph[team[i]].add(team[j])
            indegree[team[j]] += 1

    M = int(input())
    for _ in range(M):
        a, b = map(int, input().split())
        if b in graph[a]:
            graph[a].remove(b)
            graph[b].add(a)
            indegree[a] += 1
            indegree[b] -= 1
        else:
            graph[a].add(b)
            graph[b].remove(a)
            indegree[a] -= 1
            indegree[b] += 1

    output = topology_sort(graph, indegree)
    print(*output)