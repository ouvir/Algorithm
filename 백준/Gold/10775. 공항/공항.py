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

G = int(input())
P = int(input())
array = []
for _ in range(P):
    data = int(input())
    array.append(data)

parent = [i for i in range(G+1)]

count = 0
for i in range(P):
    gate = find(parent, array[i])
    if gate == 0:
        break
    else:
        union(parent, gate, gate-1)
        count += 1
print(count)