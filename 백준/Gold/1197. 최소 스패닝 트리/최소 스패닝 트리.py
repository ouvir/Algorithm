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


V, E = map(int, input().split())
edges = []
parent = [i for i in range(V+1)]

for _ in range(E):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))

edges.sort(key=lambda x: x[2])

result = 0
count = 0
for edge in edges:
    a, b, c = edge
    if find(parent, a) != find(parent, b):
        result += c
        count += 1
        union(parent, a, b)
        if count == V-1:
            break

print(result)