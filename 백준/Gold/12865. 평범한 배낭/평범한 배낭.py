import sys

N, K = map(int, sys.stdin.readline().split())

items = []

for _ in range(N):
    items.append(list(map(int, sys.stdin.readline().split())))

d = [[0 for _ in range(K+1)] for _ in range(N+1)]

for i in range(1,N+1):
    for j in range(1,K+1):
        if items[i-1][0] <= j:
            d[i][j] = max(d[i-1][j - items[i-1][0]] + items[i-1][1], d[i-1][j])
        else:
            d[i][j] = d[i-1][j]
max_value = 0
for l in d:
    for v in l:
        if max_value < v:
            max_value = v

print(v)