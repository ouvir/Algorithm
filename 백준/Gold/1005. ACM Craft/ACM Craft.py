import sys
from collections import deque
input = sys.stdin.readline

tc = int(input())

def topology_sort(graph, indegree, delay, N, W):
    dp = [0] * (N+1)
    q = deque()
    
    for i in range(1,N+1):
        if indegree[i] == 0:
            q.append(i)
            dp[i] = delay[i-1]

    while q:
        now = q.popleft()
        if now == W:
            break       
        for e in graph[now]:
            dp[e] = max(dp[e], dp[now] + delay[e-1])
            indegree[e] -= 1
            if indegree[e] == 0:
                q.append(e)

    print(dp[W])

for _ in range(tc):
    N, K = map(int, input().split())
    delay = list(map(int, input().split()))

    graph = [[] for _ in range(N+1)]
    indegree = [0] * (N+1)

    for _ in range(K):
        a, b = map(int, input().split())
        graph[a].append(b)
        indegree[b] += 1

    W = int(input())

    topology_sort(graph, indegree, delay, N, W)