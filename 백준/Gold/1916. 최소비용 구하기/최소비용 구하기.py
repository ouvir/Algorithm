import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)

N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]
distance = [INF] * (N+1)

for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b,c))
    
def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    
    while q:
        d, now = heapq.heappop(q)
        if d > distance[now]:
            continue
        for e in graph[now]:
            cost = d + e[1]
            if cost < distance[e[0]]:
                distance[e[0]] = cost
                heapq.heappush(q, (cost, e[0]))

start, end = map(int,input().split())

dijkstra(start)

print(distance[end])