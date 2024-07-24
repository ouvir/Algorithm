import sys
import heapq

input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]
indegree = [0] * (N+1)

for _ in range(M):
    a, b = map(int, input().split())
    heapq.heappush(graph[a], b)
    indegree[b] += 1

def topology_sort():
    output = []
    q = []
    
    for i in range(1,N+1):
        if indegree[i] == 0:
            heapq.heappush(q,i)

    while q:
        now = heapq.heappop(q)
        output.append(now)

        while graph[now]:
            e = heapq.heappop(graph[now])
            indegree[e] -= 1
            if indegree[e] == 0:
                heapq.heappush(q,e)
    
    print(*output)

topology_sort()