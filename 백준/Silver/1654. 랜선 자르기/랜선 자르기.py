import sys

K, N = map(int, sys.stdin.readline().split())

have = [int(sys.stdin.readline()) for _ in range(K)]

start = 1
end = max(have)

result = 0
while start <= end:
    count = 0
    mid = (start + end) // 2

    for line in have:
        count += (line // mid)

    if count >= N:
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)