import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def find(parent, a):
    if parent[a] != a:
        parent[a] = find(parent, parent[a])
    return parent[a]


def union(parent, a, b):
    a = find(parent, a)
    b = find(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


V, E = map(int, input().split())
parent = [i for i in range(V + 1)]
edges = []

for _ in range(E):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))

edges.sort(key=lambda x: x[2])

result = 0
count = 0
for edge in edges:
    a, b, c = edge
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        result += c
        count += 1
        if count == V - 1:
            break
print(result)
