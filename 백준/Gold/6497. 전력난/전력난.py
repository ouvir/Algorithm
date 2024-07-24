import sys

input = sys.stdin.readline

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

while True:
    M, N = map(int, input().split())
    
    if M == 0 and N == 0:
        break

    parent = [i for i in range(M+1)]

    edges = []

    total_pay = 0

    for _ in range(N):
        a, b, c = map(int,input().split())
        edges.append((c,a,b))
        total_pay += c

    edges.sort()

    result = 0
    for edge in edges:
        c, a, b = edge
        if find(parent,a) != find(parent, b):
            union(parent, a, b)
            result += c

    print(total_pay - result)