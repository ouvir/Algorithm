# 공식 N! / (K! * (N-K)!)

N, K = map(int, input().split())

output = 1

for i in range(N, K, -1):
    output *= i

for i in range(1, N-K+1):
    output //= i
print(output)