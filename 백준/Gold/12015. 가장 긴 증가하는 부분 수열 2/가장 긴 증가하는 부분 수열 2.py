import sys

input = sys.stdin.readline

N = int(input())

A = list(map(int, input().split()))

LIS = [0]

for a in A:
    if a > LIS[-1]:
        LIS.append(a)
    else: # 이분탐색으로 들어갈 위치 탐색
        start = 0
        end = len(LIS)

        while start < end:
            mid = (start + end) // 2

            if LIS[mid] < a:
                start = mid + 1
            else:
                end = mid

        LIS[end] = a

print(len(LIS) - 1)