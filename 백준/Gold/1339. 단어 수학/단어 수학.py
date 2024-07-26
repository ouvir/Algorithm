import sys

input = sys.stdin.readline

N = int(input())
alpha = [0] * (26)
number = [i for i in range(10)]

for _ in range(N):
    word = list(map(str, input().rstrip()))
    
    for i in range(len(word)):
        alpha[ord(word[i]) - 65] += 10 ** (len(word) - i - 1)

alpha.sort(reverse=True)

result = 0
for v in alpha:
    if v == 0:
        break
    result += v * number.pop()

print(result)