import sys
import heapq
import copy
input = sys.stdin.readline
INF = int(1e9)

N = int(input())
M = int(input())

graph = [ [] for _ in range(N+1)]
distance = [INF] * (N+1)
routes = [ [] for _ in range(N+1)]

for _ in range(M):
    a, b, c= map(int,input().split())
    graph[a].append((b,c))

start, end = map(int, input().split())

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start, [start]))
    distance[start] = 0
    routes[start].append(start)

    while q:
        d, now, route = heapq.heappop(q)
        if d > distance[now]:
            continue
        for e in graph[now]:
            cost = d + e[1]
            if cost < distance[e[0]]:
                tmp = copy.deepcopy(route)
                tmp.append(e[0])
                distance[e[0]] = cost
                routes[e[0]] = tmp
                heapq.heappush(q, (cost, e[0], tmp))

dijkstra(start)

print(distance[end])
print(len(routes[end]))
print(*routes[end])