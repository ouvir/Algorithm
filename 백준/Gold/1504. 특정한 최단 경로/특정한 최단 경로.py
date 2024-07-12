import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)

N, E = map(int, input().split())

graph = [[] for _ in range(N+1)]
distance = [INF] * (N + 1)

for _ in range(E):
    a,b,c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

v1, v2 = map(int, input().split())

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
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

output_1 = 0
output_2 = 0


dijkstra(1)
output_1 += distance[v1]
output_2 += distance[v2]

distance = [INF] * (N + 1)

dijkstra(v1)
output_1 += distance[v2]
output_2 += distance[N]

distance = [INF] * (N + 1)

dijkstra(v2)
output_1 += distance[N]
output_2 += distance[v1]


output = min(output_1, output_2)

if output >= INF:
    print(-1)
else:
    print(output)