import sys

input = sys.stdin.readline

N, M = map(int, input().split())

trees = list(map(int,input().split()))
start = 0
end = 1000000000

result = 0
while start <= end:
    count = 0
    mid = (start + end)//2

    for tree in trees:
        if tree - mid > 0:
            count += tree - mid
    
    if count >= M:
        result = max(result, mid)
        start = mid + 1
    else:
        end = mid - 1

print(result)