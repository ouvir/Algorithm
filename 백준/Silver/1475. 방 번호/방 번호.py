import sys

N = list(map(int, sys.stdin.readline().rstrip()))

memo = dict()

for number in N:
    tmp = number
    if number == 9: #9를 모두 6으로 바꿔줌
        tmp = 6
    if tmp in memo:
        memo[tmp] += 1
    else:
        memo[tmp] = 1

if 6 in memo:
    memo[6] = memo[6] // 2 if memo[6] % 2 == 0 else memo[6] // 2 + 1

print(max(memo.values()))