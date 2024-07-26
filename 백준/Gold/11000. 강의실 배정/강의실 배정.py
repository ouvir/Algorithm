import sys
import heapq
input = sys.stdin.readline

N = int(input())

lectures = []

for _ in range(N):
    s, t = map(int, input().split())
    lectures.append((s,t))

lectures.sort()
q = []

count = 0
for s, t in lectures:
    if not q:
        heapq.heappush(q, (t,s))
        count += 1
        continue
    b_t, b_s = heapq.heappop(q) # 이미 강의실을 배정 받은 수업

    if b_t > s:
        heapq.heappush(q, (b_t, b_s))
        count += 1
    heapq.heappush(q, (t, s))
print(count)