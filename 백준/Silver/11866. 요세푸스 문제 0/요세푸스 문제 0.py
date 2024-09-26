from collections import deque

N, K = map(int, input().split())

queue = deque()

for i in range(1,N+1):
    queue.append(i)

output = []
count = 0
while queue:
    now = queue.popleft()
    count += 1
    
    if count == K:
        output.append(now)
        count = 0
    else:
        queue.append(now)
print("<", end="")
print(*output, sep=", ", end="")
print(">")