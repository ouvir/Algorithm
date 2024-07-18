import sys

input = sys.stdin.readline

N = int(input())
K = int(input())

result = int(1e9)

start = 1
end = min(int(1e9), N**2)

while start <= end:
    mid = (start + end) // 2

    # N 순회
    count = 0
    for i in range(1,N+1):
        count += min(N, mid // i)

    if count >= K:
        result = min(result, mid)
        end = mid - 1
    else:
        start = mid + 1

print(result)