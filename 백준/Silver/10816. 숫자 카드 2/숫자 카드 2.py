import sys
from collections import defaultdict

N = int(sys.stdin.readline())
have = list(map(int,sys.stdin.readline().split()))

M = int(sys.stdin.readline())
want = list(map(int,sys.stdin.readline().split()))

have_map = defaultdict(int)

for h in have:
	have_map[h] += 1

print(" ".join(map(str, [ have_map[w] for w in want])))