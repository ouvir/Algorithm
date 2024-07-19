import sys

input = sys.stdin.readline

S = input().rstrip()

default = S[0]
tmp = S[0]
count = 0
for s in S[1:]:
    if default != s and tmp != s:
        count += 1
    tmp = s
print(count)