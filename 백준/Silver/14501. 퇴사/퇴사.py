import sys
input = sys.stdin.readline

N = int(input())

T = [0] * (N+1)
P = [0] * (N+1)

for i in range(1,N+1):
    t, p = map(int,input().split())
    T[i] = t
    P[i] = p

dp = [0] * (N+2)
max_value = 0

for i in range(N, 0, -1):
    time = T[i] + i
    if time <= N+1:
        dp[i] = max(max_value, dp[time] + P[i])
        max_value = dp[i]
    else:
        dp[i] = max_value

print(max(dp))