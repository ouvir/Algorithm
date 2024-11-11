import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    a, b = map(int, input().split())
    a %= 10  # 마지막 자릿수만 고려하면 되므로 10으로 나눔
    if b == 0:
        tmp = 1
    else:
        exponent = b % 4 if b % 4 != 0 else 4
        tmp = pow(a, exponent, 10)
    if tmp == 0:
        tmp = 10
    print(tmp)
