# 5
# 3 2 1 -3 -1
# 1 4 5 3 2
from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
graph = list(map(int, input().split()))

q = []
for i in range(N):
    q.append((i+1,graph[i]))

q = deque(q)

while q:
    idx, now = q.popleft()
    print(idx, end=" ")

    if q:
        if now > 0:
            for _ in range(now-1):
                q.append(q.popleft())
        elif now < 0:
            for _ in range(now, 0, 1):
                q.appendleft(q.pop())