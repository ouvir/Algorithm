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

N, M = map(int, input().split())
edges = []
parent = [i for i in range(N+1)]

for _ in range(M):
    a, b, c = map(int, input().split())
    edges.append((c, a, b))  # 비용 기준으로 정렬하기 위해 순서 변경

edges.sort()
result = 0
max_edge = 0

for c, a, b in edges:
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        result += c
        max_edge = max(max_edge, c)

print(result - max_edge)
