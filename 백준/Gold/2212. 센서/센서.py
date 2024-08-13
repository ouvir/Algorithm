import sys
input = sys.stdin.readline

N = int(input())
K = int(input())
sensor = list(map(int, input().split()))

sensor.sort()

distance = []
for i in range(N-1):
    d = abs(sensor[i] - sensor[i+1])
    distance.append(d)
    
distance.sort()

if len(distance) <= K:
    print(0)
else:
    for _ in range(K-1):
        distance.pop()
    print(sum(distance))