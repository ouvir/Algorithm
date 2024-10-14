# 유클리드 호제법으로 구해보자.
import sys
input = sys.stdin.readline

def GCD(a, b):
    if b == 0:
        return a
    else:
        return GCD(b, a % b)

def check(a, b):
    for i in range(a + 1, b):
        if GCD(a, i) == 1 and GCD(i, b) == 1:
            return 1
    return 2

N = int(input())
numbers = list(map(int, input().split()))
numbers.sort()

answer = 0
for i in range(N - 1):
    if GCD(numbers[i], numbers[i + 1]) != 1:
        answer += check(numbers[i], numbers[i + 1])
print(answer)