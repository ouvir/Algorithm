import sys

N = int(sys.stdin.readline())

lines = []

for _ in range(N):
    lines.append(list(map(int, sys.stdin.readline().split())))

d = [1] * N

lines.sort(key=lambda x: x[0])

for i in range(1,N):
    for j in range(i):
        if lines[i][1] > lines[j][1]:
            d[i] = max(d[i], d[j] + 1)

print(N - max(d))
