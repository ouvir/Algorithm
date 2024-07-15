import sys

N, M = map(int, sys.stdin.readline().split())

bucket = [i for i in range(1, N + 1)]

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    bucket[a-1], bucket[b-1] = bucket[b-1], bucket[a-1]

print(*bucket)
    