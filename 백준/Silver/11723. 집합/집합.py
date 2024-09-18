import sys
M = int(sys.stdin.readline())

def all(S):
    for i in range(1,21):
        S[str(i)] = 1
def empty(S):
    for i in range(1,21):
        S[str(i)] = 0

S = dict()
empty(S)

for _ in range(M):
    data = sys.stdin.readline().rstrip()
    if data == 'all':
        all(S)
    elif data == 'empty':
        empty(S)
    else:
        order, x = data.split()
        if order == 'add':
            S[x] = 1
        elif order == 'remove':
            S[x] = 0
        elif order == 'check':
            if S[x]:
                print(1)
            else:
                print(0)
        elif order == 'toggle':
            if S[x]:
                S[x] = 0
            else:
                S[x] = 1