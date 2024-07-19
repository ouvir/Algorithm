import sys

input = sys.stdin.readline

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a,b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


N = int(input())

result = 0
parent = [i for i in range(N+1)]

x = []
y = []
z = []


for i in range(1,N+1):
    a,b,c = map(int,input().split())
    x.append((a,i))
    y.append((b,i))
    z.append((c,i))

x.sort()
y.sort()
z.sort()

edges = []

for i in range(1,N):
    if x[i][0] - x[i-1][0] > 0:
        edges.append((x[i][0] - x[i-1][0], x[i][1], x[i-1][1]))
    else:
        edges.append(((x[i][0] - x[i-1][0])*-1, x[i][1], x[i-1][1]))

    if y[i][0] - y[i-1][0] > 0:
        edges.append((y[i][0] - y[i-1][0], y[i][1], y[i-1][1]))
    else:
        edges.append(((y[i][0] - y[i-1][0])*-1, y[i][1], y[i-1][1]))

    if z[i][0] - z[i-1][0] > 0:
        edges.append((z[i][0] - z[i-1][0], z[i][1], z[i-1][1]))
    else:
        edges.append(((z[i][0] - z[i-1][0])*-1, z[i][1], z[i-1][1]))

edges.sort()

for edge in edges:
    c, a, b = edge
    if find_parent(parent, a) != find_parent(parent,b):
        result += c
        union_parent(parent, a, b)
        
print(result)