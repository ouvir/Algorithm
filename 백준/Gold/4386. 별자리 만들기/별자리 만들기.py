import sys
import math

input = sys.stdin.readline

def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]

def union(parent,a,b):
    a = find(parent, a)
    b = find(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

N = int(input())

nodes = []
parent = [i for i in range(N+1)]

for i in range(1,N+1):
    x, y = map(float, input().split())
    nodes.append((i, int(x*100),int(y*100)))

edges = []

for i in range(N):
    for j in range(i,N):
        a, x, y = nodes[i]
        b, cx, cy = nodes[j]
        dx = x - cx if x - cx >= 0 else cx - x
        dy = y - cy if y - cy >= 0 else cy - y
        edges.append((math.sqrt(dx ** 2 + dy ** 2), a, b))

edges.sort()

result = 0
for edge in edges:
    c, a, b = edge
    if find(parent, a) != find(parent, b):
        result += c
        union(parent, a, b)

print(result / 100)