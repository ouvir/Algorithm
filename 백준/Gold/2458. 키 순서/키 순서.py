import sys

input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split())

graph = [[INF] * (N+1) for i in range(N+1)]
for i in range(1, N+1):
    graph[i][i] = 0

for _ in range(M):
    a,b = map(int, input().split())
    graph[a][b] = 1

for k in range(1,N+1):
    for i in range(1,N+1):
        for j in range(1,N+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

count = 0
for i in range(1,N+1):
    tmp = 0
    for j in range(1,N+1):
        if graph[i][j] != INF or graph[j][i] != INF:
            tmp += 1
    if tmp == N:
        count += 1

print(count)