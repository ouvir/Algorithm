import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)

def dijkstra(start):
    q = []

    distance = [INF] * (n + 1)

    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
       
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    return distance


tc = int(input())

for _ in range(tc):
    n, m, t = map(int, input().split())

    s, g, h = map(int, input().split())

    graph = [[] for _ in range(n+1)]

    for _ in range(m):
        a, b, d = map(int, input().split())
        graph[a].append((b, d))
        graph[b].append((a, d))

    # 목적지 후보
    candidate = []
    for _ in range(t):
        candidate.append(int(input()))

    first = dijkstra(s)
    g_dijk = dijkstra(g)
    h_dijk = dijkstra(h)

    result = []

    for c in candidate:
        # start > g > h > 후보 = 최종 경로 비용 or start > h > g > 후보 == 최종 경로 비용 인 애들인지 확인
        if first[g] + g_dijk[h] + h_dijk[c] == first[c] or first[h] + h_dijk[g] + g_dijk[c] == first[c]:
            result.append(c)

    result.sort()

    print(*result)