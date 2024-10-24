from collections import deque
T = 10

dx = [0, 0, -1]
dy = [1, -1, 0]

for test_case in range(1, T + 1):
    tc = int(input())
    N = 100
    graph = [list(map(int, input().split())) for _ in range(N)]
    
    output = 0
    
    q = deque()
    q.append((N-1, graph[N-1].index(2)))
    visited = [[False] * 100 for _ in range(100)]
    while q:
        x, y = q.popleft()
        
        if x == 0:
            output = y
            break
            
        for i in range(3):
            cx = dx[i] + x
            cy = dy[i] + y
            if cy < 0 or cy >=N or cx < 0 or cx >= N:
                continue
            if visited[cx][cy]:
                continue
            if graph[cx][cy] == 1:
                visited[cx][cy] = True
                q.append((cx, cy))
                break
    print(f"#{test_case} {output}")