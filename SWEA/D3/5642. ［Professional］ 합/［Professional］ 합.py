# DP 문제
# i -> 문자열을 증가시켜가며, 확인
# dp[i] -> 0~i번째 문자열까지의 최대 연속 합
# dp[i] = max(dp[i-1] + numbers[i], numbers[i])
# 최종: max(dp)
INF = int(1e9)
T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    numbers = list(map(int, input().split()))
    dp = [-INF] * (N)
    dp[0] = numbers[0]
    for i in range(1, N):
        dp[i] = max(dp[i-1] + numbers[i], numbers[i])
    print(f"#{test_case} {max(dp)}")