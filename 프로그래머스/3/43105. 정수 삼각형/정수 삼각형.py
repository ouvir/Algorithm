def solution(triangle):
    N = len(triangle)
    dp = [[0] * N for i in range(N)]
    
    for i in range(N):
        for j in range(i+1):
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
    
    return max(dp[N-1])