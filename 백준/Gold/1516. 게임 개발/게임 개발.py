import sys
from collections import deque

input = sys.stdin.readline
N = int(input())

graph = [ [] for _ in range(N+1) ]
indegree = [0] * (N+1)
dp = [0] * (N+1)
times = [0] * (N+1)

for i in range(1, N+1):
    data = list(map(int, input().split()))
    times[i] = data[0]

    for e in data[1:]:
        if e == -1:
            break
        graph[e].append(i)
        indegree[i] += 1

q = deque()

for i in range(1, N+1):
    if indegree[i] == 0:
        dp[i] = times[i]
        q.append(i)

while q:
    now = q.popleft()

    for e in graph[now]:
        indegree[e] -= 1
        dp[e] = max(dp[e], dp[now] + times[e])
        if indegree[e] == 0:
            q.append(e)

for i in range(1,N+1):
    print(dp[i])