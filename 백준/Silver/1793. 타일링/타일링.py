# dp
# dp[i] = i*n의 타일을 채우는 경우의 수
# dp[i] = (dp[i-1] + (dp[i-2] * 2))
# dp[0] = 1
# dp[1] = 1

import sys
input = sys.stdin.readline

while True:
    try:
        n = int(input())
        dp = [1] * (n+1)
        for i in range(2, n+1):
            dp[i] = (dp[i-1] + (dp[i-2] * 2))
        
        print(dp[n])
    except:
        break