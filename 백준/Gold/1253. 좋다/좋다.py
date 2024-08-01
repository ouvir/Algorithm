import sys

input = sys.stdin.readline
def binary_search(array, target, start, end, i, j):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            if mid == j or mid == i:
                start = mid + 1
            else:
                return True
        elif array[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return False

N = int(input())

numbers = list(map(int, input().split()))

numbers.sort()

count = 0
for i in range(N):
    target = numbers[i]
    for j in range(N):
        if i == j:
            continue
        goal = target - numbers[j]
        start = 0
        end = N - 1
        
        if binary_search(numbers, goal, start, end, i, j):
            count += 1
            break

print(count)