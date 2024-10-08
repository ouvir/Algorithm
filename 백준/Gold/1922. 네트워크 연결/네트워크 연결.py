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
M = int(input())
parent = [i for i in range(N+1)]
edges = []
for _ in range(M):
    a, b, c = map(int, input().split())
    edges.append((a,b,c))
    
edges.sort(key = lambda x : x[2])

result = 0
cnt = 0
for edge in edges:
    a, b, c = edge
    if find(parent, a) != find(parent, b):
        result += c
        cnt += 1
        union(parent, a, b)
        if cnt == N-1:
            break
print(result)