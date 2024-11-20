import sys

input = sys.stdin.readline

N, M = map(int, input().split())

words = dict()

for _ in range(N):
    word = input().rstrip()
    if len(word) >= M:
        if word in words:
            words[word] += 1
        else:
            words[word] = 1

result = []
for k, v in words.items():
    result.append((k,v))

result.sort(key=lambda x: (-x[1], -len(x[0]), x[0]))

for r in result:
    print(r[0])