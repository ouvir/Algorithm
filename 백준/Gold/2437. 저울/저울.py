import sys
input = sys.stdin.readline

N = int(input())

weight = list(map(int,input().split()))

weight.sort()

target = 1
for w in weight:
    if target < w:
        break
    target += w
    
print(target)