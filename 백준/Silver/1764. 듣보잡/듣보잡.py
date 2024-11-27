N, M = map(int, input().split())

noListen = set()
noSee = set()
output = []

for _ in range(N):
    noListen.add(input())

for _ in range(M):
    noSee.add(input())

for p in noListen:
    if p in noSee:
        output.append(p)

output.sort()

print(len(output))
for i in output:
    print(i)