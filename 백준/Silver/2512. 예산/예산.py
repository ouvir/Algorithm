# 정수 상한액 배정 문제
# 총 예산 -> N ~ int(1e9)
# 떡 자르기 유형
# 이분 탐색으로 상한액을 탐색
# 이분 탐색마다, 모든 예산 요청을 확인하며, 배정하는 상한액 산정
# 시간복잡도: 이분탐색 * 순회 -> NlogM -> 10000 * 30

import sys
input = sys.stdin.readline

N = int(input())
requests = list(map(int,input().split()))
M = int(input())

start = 0
end = M

result = 0
if sum(requests) <= M:
    print(max(requests))

else:
    while start <= end:
        mid = (start + end) // 2

        count = 0 # 총 필요 예산
        for request in requests:
            count += request if mid >= request else mid
        
        if count == M:
            result = mid
            break

        elif count > M:
            end = mid - 1

        else:
            result = max(result, mid)
            start = mid + 1

    print(result)