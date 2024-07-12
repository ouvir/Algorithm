import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)

V, E = map(int, input().split())
K = int(input())

graph = [[] for _ in range(V+1)]
distance = [INF] * (V+1)

for _ in range(E):
    u,v,w = map(int, input().split())
    graph[u].append((v, w))

def dijkstra(start):
    q = []
    heapq.heappush(q, (0,start))
    distance[start] = 0

    while q:
        d, now = heapq.heappop(q)
        if distance[now] < d:
            continue
        
        for e in graph[now]:
            cost = d + e[1]
            if cost < distance[e[0]]:
                distance[e[0]] = cost
                heapq.heappush(q,(cost, e[0]))

dijkstra(K)

for i in range(1, V+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])
