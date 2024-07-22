import sys

N = int(sys.stdin.readline())

infos = []

for _ in range(N):
	name, k, e, m = map(str, sys.stdin.readline().rstrip().split())
	infos.append((name,int(k),int(e),int(m)))

infos.sort(key=lambda x: (-x[1],x[2],-x[3],x[0]))

for info in infos:
	print(info[0])