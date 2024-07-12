import sys
input = sys.stdin.readline

N = int(input())
items = list(map(int, input().split()))

items.sort(key=lambda x : x if x >= 0 else x * -1)

min_d = int(1e10)
output = []

for i in range(N-1):
    d = items[i] + items[i+1]
    if d < 0:
        d *= -1
    if min_d > d:
        min_d = d
        output = [items[i],items[i+1]]

output.sort()
print(*output)