import sys
from collections import deque

N = int(sys.stdin.readline())

Map = [list(map(str,sys.stdin.readline().rstrip())) for _ in range(N)]

dx = [1,0,-1,0]
dy = [0,1,0,-1]

visited_n = [[0 for _ in range(N)] for _ in range(N)]
visited_r = [[0 for _ in range(N)] for _ in range(N)]

def bfs_n(Map, start, count):
    queue = deque()
    queue.append((start[0],start[1]))
    visited_n[start[0]][start[1]] = 1
    
    count += 1
    
    check = Map[start[0]][start[1]]

    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            cx,cy = x + dx[i] , y + dy[i]
            if cx < 0 or cx >= N or cy < 0 or cy >= N:
                continue
            if Map[cx][cy] == check and visited_n[cx][cy] == 0:
                visited_n[cx][cy] = 1
                queue.append((cx,cy))

    for i in range(N):
        for j in range(N):
            if visited_n[i][j] == 0:
                count = bfs_n(Map, (i,j), count)
    return count
    

    
def bfs_r(Map, start, count):
    queue = deque()
    queue.append((start[0],start[1]))
    visited_r[start[0]][start[1]] = 1
    
    count += 1
    
    check = Map[start[0]][start[1]]

    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            cx,cy = x + dx[i] , y + dy[i]
            if cx < 0 or cx >= N or cy < 0 or cy >= N:
                continue
            if check == 'B':
                if Map[cx][cy] == check and visited_r[cx][cy] == 0:
                    visited_r[cx][cy] = 1
                    queue.append((cx,cy))
            else:
                if (Map[cx][cy] == 'R' or Map[cx][cy] == 'G') and visited_r[cx][cy] == 0:
                    visited_r[cx][cy] = 1
                    queue.append((cx,cy))
    for i in range(N):
        for j in range(N):
            if visited_r[i][j] == 0:
                count = bfs_r(Map, (i,j), count)
    return count



print(bfs_n(Map, (0,0), 0), end=" ")
print(bfs_r(Map, (0,0), 0))