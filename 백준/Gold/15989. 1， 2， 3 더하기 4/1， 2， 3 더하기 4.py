# N 이라는 수를 1,2,3으로 나타내는 경우의 수
# 1로만 표현
# 1, 2로만 표현 dp[1] 1 dp[2] 2 dp[3] = 2, dp[4] = 3
# -> dp[i] = dp[i-2] + dp[i]

# 1, 2, 3으로 표현
# -> dp[i] = dp[i-3] + dp[i]

T = int(input())

dp = [1] * 10001  # 1만 사용

for i in range(2, 10001):
    dp[i] += dp[i - 2]
for i in range(3, 10001):
    dp[i] += dp[i - 3]

for _ in range(T):
    N = int(input())
    print(dp[N])