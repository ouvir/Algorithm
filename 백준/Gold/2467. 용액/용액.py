# 이분 탐색 같음
# -> logN
# -> 순회 + 이분탐색?
# -> NlogN 까지 가능

# 현재 용액과 그 이후 나머지 용액들 중 가장 차이가 적은 애 계속 select 하기
# N 으로 순회하며, 현재 용액 선택
# 이분 탐색으로 나머지 용액들 중 차이가 가장 적은 애 찾기
# 두 용액의 합이 음수 -> start = mid + 1
# 두 용액의 합이 양수 -> end = mid - 1
# 저장할 변수: 용액 2개, 차이 값

import sys
input = sys.stdin.readline

N = int(input())

liquids  = list(map(int, input().split()))
result = int(1e10)
first, second = (0, 0)

def binary_search(array, now, start, end):
    min_d = int(1e10)
    liquid = 0

    while start <= end:
        mid = (start + end) // 2
        d = array[mid] + now
        
        if abs(d) < min_d:
            min_d = abs(d)
            liquid = array[mid]
        
        if d < 0:
            start = mid + 1
        else:
            end = mid - 1

    return min_d, liquid

for i in range(N-1):
    now = liquids[i]
    start, end = (i+1, N-1)
    value, liquid = binary_search(liquids, now, start, end)    
    if value < result:
        result = value
        first = now
        second = liquid

print(first, second)