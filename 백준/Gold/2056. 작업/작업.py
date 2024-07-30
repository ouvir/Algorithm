import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
times = [0] * (N+1)
dp = [0] * (N+1)
indegrees = [0] * (N+1)
graph = [[] for _ in range(N+1)]

for i in range(1,N+1):
    data = list(map(int, input().split()))
    times[i] = data[0]
    for j in range(data[1]):        
        graph[data[2+j]].append(i)
        indegrees[i] += 1

q = deque()

for i in range(1,N+1):
    if indegrees[i] == 0:
        q.append((i))
        dp[i] = times[i]

while q:
    now = q.popleft()
    
    for e in graph[now]:
        indegrees[e] -= 1
        dp[e] = max(dp[e], dp[now] + times[e])
        if indegrees[e] == 0:
            q.append((e))

print(max(dp))