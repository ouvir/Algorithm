import sys

N, C = map(int, sys.stdin.readline().split())

pos = [int(sys.stdin.readline()) for _ in range(N)]

pos.sort()

start = 1
end = pos[-1] - pos[0] 

result = 0
while start <= end:
    mid = (start + end) // 2
    count = 1 # 공유기의 수
    distance = 0 # 누적 거리 합
    for i in range(N-1):
        if pos[i+1] - pos[i] + distance >= mid:
            count += 1
            distance = 0
        else: 
            distance += pos[i+1] - pos[i]

    if count >= C:
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)