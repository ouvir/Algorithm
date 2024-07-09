import sys

N = int(sys.stdin.readline())

origin = list(map(int, sys.stdin.readline().split()))

new = list(set(origin))
new.sort()

page = dict()

for i in range(len(new)):
    page[new[i]] = i

print(" ".join([str(page[n]) for n in origin]))