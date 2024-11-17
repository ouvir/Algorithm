import sys
input = sys.stdin.readline

N = int(input())

info = list(map(int, input().split()))
output = [N+1] * (N)

for height in range(1, N+1): # 번호(==키)
    count = 0
    for i in range(N):
        if output[i] == N+1:
            if count == info[height-1]:
                output[i] = height
                break
            count += 1
print(*output)