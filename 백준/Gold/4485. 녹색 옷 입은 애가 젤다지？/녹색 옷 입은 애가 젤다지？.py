import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)


dx = [1,0,-1,0]
dy = [0,1,0,-1]
i = 1

while True:
    N = int(input())
    if N == 0:
        break

    graph = [list(map(int, input().split())) for _ in range(N)]
    distance = [[INF] * (N) for i in range(N)]

    def dijkstra(graph, distance):
        q = []
        heapq.heappush(q, (graph[0][0], (0,0)))
        distance[0][0] = graph[0][0]

        while q:
            d, now = heapq.heappop(q)
            x, y = now
            if d > distance[x][y]:
                continue
            for i in range(4):
                cx, cy = dx[i] + x, dy[i] + y
                if cx < 0 or cx >= N or cy < 0 or cy >= N:
                    continue
                cost = d + graph[cx][cy]
                if cost < distance[cx][cy]:
                    distance[cx][cy] = cost
                    heapq.heappush(q,(cost, (cx, cy)))          
            
        return distance[N-1][N-1]

    value = dijkstra(graph, distance)
    print(f"Problem {i}: {value}")
    i += 1