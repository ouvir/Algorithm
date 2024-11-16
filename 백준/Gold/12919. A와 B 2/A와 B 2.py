from collections import deque

S = input()
T = input()

output = 0

def check(a, b):
    N = len(a)
    for i in range(N):
        if a[i] != b[i]:
            return False
    return True
def bfs(start):
    global output
    q = deque()
    q.append(start)

    while q:
        now = q.popleft()
        if len(now) == len(S):
            if check(S, now):
                output = 1
                break
            continue

        if now[-1] == 'A':
            q.append(now[:-1])

        if now[0] == 'B':
            q.append(now[::-1][:-1])

bfs(T)

print(output)