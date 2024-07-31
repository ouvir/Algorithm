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

N, P = map(int,input().split())

costs = [0] * (N+1)
edges = []
parent = [i for i in range(N+1)]

for i in range(1, N+1):
    costs[i] = int(input())

for _ in range(P):
    a, b, c = map(int, input().split())
    cost = costs[a] + c*2 + costs[b]
    edges.append((a, b, cost))

edges.sort(key=lambda x : x[2])

result = 0
start = 0
for i in range(len(edges)):
    a, b, c = edges[i]
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        result += c


print(result+ min(costs[1:]))