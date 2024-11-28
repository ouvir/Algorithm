from collections import deque

N = int(input())

numbers = [i for i in range(1, N+1)]

q = deque(numbers)

output = 0
while q:
    now = q.popleft()
    if not q:
        output = now
        break
    q.append(q.popleft())
print(output)