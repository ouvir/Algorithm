# union-find를 통해, 총 개수 구하기

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

for _ in range(M):
    a, b = map(int, input().split())
    union(parent, a, b)

count = set()

for i in range(1,N + 1):
    find(parent, i)
    count.add(parent[i])

print(len(count))