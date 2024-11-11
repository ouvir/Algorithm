import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    a, b = map(int, input().split())
    tmp = a
    tmp %= 10

    for _ in range(b-1):
        tmp *= a
        tmp %= 10

    if tmp == 0:
        tmp = 10
    print(tmp)