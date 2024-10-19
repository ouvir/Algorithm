import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    coins = list(map(int, input().split()))
    M = int(input())
    DP = [0] * (M+1) #DP[i] = i원을 만드는 가짓 수
    DP[0] = 1
    
    for coin in coins:
        for i in range(1, M+1):
            if (i - coin) >= 0:
                DP[i] += DP[i-coin]
    print(DP[M])