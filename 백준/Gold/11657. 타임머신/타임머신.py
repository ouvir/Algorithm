import sys
input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split())

edges = []
distance = [INF] * (N+1)

for _ in range(M):
    a, b, c = map(int, input().split())
    edges.append((a,b,c))

def bf(start):
    distance[start] = 0
    
    for i in range(N):
        for j in range(M):
            a, b, c = edges[j]
            if distance[a] != INF and distance[b] > distance[a] + c:
                distance[b] = distance[a] + c
                if i == N-1:
                    return True
    return False

cycle = bf(1)

if cycle:
    print(-1)
else:
    for i in range(2,N+1):
        if distance[i] == INF:
            print(-1)
        else:
            print(distance[i])