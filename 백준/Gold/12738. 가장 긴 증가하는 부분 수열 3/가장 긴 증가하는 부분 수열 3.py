import sys

input = sys.stdin.readline

N = int(input())
array = list(map(int, input().split()))

LIS = [-1000000001]

def binary_search(array, start, end):
    output = end

    while start <= end:
        mid = (start + end) // 2
        if array[mid] >= n:
            output = mid if mid < output else output
            end = mid - 1
        else:
            start = mid + 1

    return output 

for n in array:
    if LIS[-1] < n:
        LIS.append(n)
    else:
        index = binary_search(LIS, 0, len(LIS)-1)
        LIS[index] = n

print(len(LIS) - 1)