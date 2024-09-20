import sys
input = sys.stdin.readline

N = int(input())
liquids = list(map(int, input().split()))

liquids.sort()

output = []
mixed = int(1e9 * 3)

for i in range(N):
    first = liquids[i]

    start = 0
    end = N-1
    while start < end:
        if start == i:
            start += 1
            continue
        if end == i:
            end -= 1
            continue

        second = liquids[start]
        third = liquids[end]

        if abs(first + second + third) < mixed:
            mixed = abs(first + second + third)
            output = [first, second, third]
        
        if first + second + third > 0:
            end -= 1
        else:
            start += 1

print(*output)