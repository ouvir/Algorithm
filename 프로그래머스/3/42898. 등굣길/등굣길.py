from collections import deque

def solution(m, n, puddles):
    graph = [[0] * (m) for _ in range(n)]
    visited = [[[m + n, 0] for _ in range(m)] for _ in range(n)]
    
    for y, x in puddles:
        graph[x-1][y-1] = 1

    dx = [1, 0]
    dy = [0, 1]
    
    q = deque()
    q.append((0,0,0)) # distance, x, y

    visited[0][0] = [0, 1]
    
    while q:
        d, x, y  = q.popleft()
        
        for i in range(2):
            cx, cy = dx[i] + x, dy[i] + y
            
            if cx >= n or cy >= m:
                continue
            if graph[cx][cy] == 1:
                continue
            if visited[cx][cy][0] < d + 1:
                continue
            elif visited[cx][cy][0] == d + 1:
                visited[cx][cy][1] += visited[x][y][1]
            else:
                visited[cx][cy][0] = d + 1
                visited[cx][cy][1] = visited[x][y][1]
                q.append((d+1, cx, cy)) 
            
    return visited[n-1][m-1][1] % 1000000007
