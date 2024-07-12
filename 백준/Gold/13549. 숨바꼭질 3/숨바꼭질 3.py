import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)

N, K = map(int, input().split())

graph = [[] for _ in range(100001)]

distance = [INF] * (100001)

for i in range(100001):
    if i * 2 <= 100000:
        graph[i].append((i * 2, 0))
    if i + 1 <= 100000:
        graph[i].append((i + 1, 1))
    if i - 1 >= 0:
        graph[i].append((i - 1, 1))

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
                heapq.heappush(q, (cost, e[0]))

dijkstra(N)
print(distance[K])