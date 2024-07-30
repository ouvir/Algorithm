import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
graph = [ list(map(str, input().rstrip().split())) for _ in range(N)]

def bfs(graph, i, j ,k):
    q = deque()
    
    for i in range(N):
        for j in range(N):
            if graph[i][j] == "T":
                q.append(((i,j), (1,0)))
                q.append(((i,j), (0,1)))
                q.append(((i,j), (-1,0)))
                q.append(((i,j), (0,-1)))

    while q:
        pos, d = q.popleft()

        cx , cy = pos[0] + d[0], pos[1] + d[1]
    
        if cx < 0 or cx >= N or cy < 0 or cy >= N:
            continue 
        if graph[cx][cy] == "O":
            continue
        if graph[cx][cy] == "S":
            return False

        q.append(((cx,cy), d))

    return True

for i in range(N**2):
    for j in range(N**2):
        for k in range(N**2):
            if graph[i//N][i%N] != 'X' or graph[j//N][j%N] != 'X' or graph[k//N][k%N] != 'X':
                continue
            else:
                graph[i//N][i%N] = 'O'
                graph[j//N][j%N] = 'O'
                graph[k//N][k%N] = 'O'

                if bfs(graph, i, j, k):
                    print('YES')
                    exit(0)

                graph[i//N][i%N] = 'X'
                graph[j//N][j%N] = 'X'
                graph[k//N][k%N] = 'X'

print('NO')