import sys

input = sys.stdin.readline

submit = [1] * (31)

for _ in range(28):
    s = int(input())
    submit[s] -= 1

for i in range(1,31):
    if submit[i] == 1:
        print(i)