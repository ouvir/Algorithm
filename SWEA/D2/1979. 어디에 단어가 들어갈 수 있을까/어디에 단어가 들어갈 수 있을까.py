from collections import deque

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    graph = [list(map(int, input().split())) for _ in range(N)]
    
    dx = [1, 0]
    dy = [0, 1]
    
    q = deque()
    for i in range(N):
        for j in range(N):
            if graph[i][j] == 1:
                q.append((i, j))

    result = 0
    while q:
        x, y = q.popleft()
        for i in range(2):
            count = 1
            if i == 0 and (x-1 >= 0 and graph[x-1][y] == 1):
                continue
            elif i == 1 and (y-1 >= 0 and graph[x][y-1] == 1): 
                continue
            while True:
                cx, cy = x + dx[i] * count, y + dy[i] * count
                if cx >= N or cx < 0 or cy >= N or cy < 0:
                    break
                elif graph[cx][cy] == 0:
                    break
                else:
                    count += 1
            if count == K:
                result += 1
    print(f"#{test_case} {result}")