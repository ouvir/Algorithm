import sys

input = sys.stdin.readline

N,M = map(int, input().split())

bucket = [i for i in range(N+1)]

for _ in range(M):
    a, b = map(int,input().split())
    bucket = bucket[:a] + list(reversed(bucket[a:b+1])) + bucket[b+1:]
    
print(*bucket[1:])