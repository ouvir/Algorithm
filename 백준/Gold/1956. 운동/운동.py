import sys
input = sys.stdin.readline
INF = int(1e9)

V, E = map(int, input().split())

graph = [[INF] * (V+1) for _ in range(V+1)]

for i in range(1, V+1):
    graph[i][i] = 0

for _ in range(E):
    a, b, c = map(int,input().split())
    graph[a][b] = c

for k in range(1, V+1):
    for i in range(1, V+1):
        for j in range(1, V+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

result = INF
for i in range(1, V+1):
    for j in range(1, V+1):
        if i == j: 
            continue
        if result > graph[i][j] + graph[j][i]:
            result = graph[i][j] + graph[j][i]

if result >= INF:
    print(-1)
else:
    print(result)
    