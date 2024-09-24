# 이분탐색으로 탐색할 것: 블루레이의 크기 중 최소
# 조건: M개의 블루레이에 모두 담아야 함.
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
lectures = list(map(int, input().split()))

start = max(lectures)
end = N * start
output = end

while start <= end:
    mid = (start + end) // 2 # 블루레이의 크기
    
    count = 1
    dump = 0
    for l in lectures:
        if dump + l <= mid:
            dump += l
        else:
            count += 1
            dump = l
        
    if count <= M:
        output = min(output, mid)
        end = mid - 1
    else:
        start = mid + 1
    
print(output)