import sys

input = sys.stdin.readline
INF = int(1e9)

tc = int(input())

def bf(start, distance, edges, V, E):
    distance[start] = 0

    for i in range(V):
        for j in range(E):
            a, b, c = edges[j]
            if distance[b] > distance[a] + c:
                distance[b] = distance[a] + c
                if i == V - 1:
                    return True
    return False

for _ in range(tc):
    N, M ,W = map(int,input().split())

    graph = [[] for _ in range(N+1)]
    edges = []
    distance = [INF] * (N+1)

    for __ in range(M):
        a, b, c = map(int,input().split())
        edges.append((a,b,c))
        edges.append((b,a,c))
    
    for __ in range(W):
        a, b, c = map(int,input().split())
        edges.append((a,b,-c))


    if bf(1, distance, edges, N, len(edges)):
        print("YES")
    else:
        print("NO")