import sys

input = sys.stdin.readline

INF = int(1e9)

N, M, R = map(int, input().split())

graph = [ [INF] * (N+1) for _ in range(N+1)]

for i in range(1,N+1):
    graph[i][i] = 0

items = list(map(int, input().split()))

for _ in range(R):
    a, b, c = map(int, input().split())
    graph[a][b] = c
    graph[b][a] = c

for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

max_item = 0

for i in range(1, N+1):
    count = 0
    for j in range(1, N+1):
        if graph[i][j] <= M:
            count += items[j-1]
    max_item = count if count > max_item else max_item

print(max_item)