# DP 문제
# 문제 = 현재 밟은 계단 + 이전 밟은 계단(sub)
# bottom-up 형태
# DP[i] = stairs[i] + max(stairs[i+1] + DP[i+3], DP[i+2])
# 초기 값: DP[N] = stairs[N]

import sys
input = sys.stdin.readline
N = int(input())

stairs = [int(input()) for _ in range(N)]
DP = [0] * N

DP[N-1] = stairs[N-1]
for i in range(N-2, -1, -1): 
    if i == N-2:
        DP[i] = stairs[i] + DP[i+1]
    elif i == N-3:
        DP[i] = stairs[i] + DP[i+2]
    else:
        DP[i] = stairs[i] + max(stairs[i+1] + DP[i+3], DP[i+2])

if N < 2:
    print(DP[0])
else:
    print(max(DP[0], DP[1]))