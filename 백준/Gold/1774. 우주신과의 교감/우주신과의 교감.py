import sys
import math

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

N, M = map(int,input().split())
parent = [i for i in range(N+1)]
edges = []
pos = []

for i in range(1, N+1):
    x, y = map(int,input().split())
    pos.append((x,y,i))

for _ in range(M):
    a, b = map(int, input().split())
    union(parent, a, b)

for i in range(N-1):
    for j in range(i, N):
        dx = pos[i][0] - pos[j][0]
        dy = pos[i][1] - pos[j][1]
        
        dx = dx if dx > 0 else -dx
        dy = dy if dy > 0 else -dy

        distance = math.sqrt(dx ** 2 + dy ** 2)
        edges.append((pos[i][2], pos[j][2], distance))

edges.sort(key=lambda x : x[2])

result = 0

for a, b, c in edges:
    if find(parent, a) != find(parent, b):
        union(parent, a, b)
        result += c

print(format(result, ".2f"))