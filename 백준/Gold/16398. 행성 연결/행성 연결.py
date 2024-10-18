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
        
N = int(input())
parent = [i for i in range(N+1)]
edges = []

matrix = []
for _ in range(N):
    matrix.append(list(map(int, input().split())))
    
for i in range(N):
    for j in range(i+1,N):
        edges.append((i, j, matrix[i][j]))

edges.sort(key=lambda x: x[2])
        
result = 0
for edge in edges:
    a, b, c = edge
    if find(parent, a) != find(parent, b):
        result += c
        union(parent, a, b)
print(result)