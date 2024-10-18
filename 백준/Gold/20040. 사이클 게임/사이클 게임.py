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
parent = [i for i in range(N+1)]

turn = 0
for t in range(1, M+1):
    a, b = map(int, input().split())
    if find(parent, a) == find(parent,b):
        turn = t
        break
    union(parent, a, b)

print(turn)