from collections import deque
T = int(input())

dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs(result, graph, pos):
    q = deque()
    start_number = str(graph[pos[0]][pos[1]])
    q.append((pos, start_number))
    
    while q:
        now, route = q.popleft()
        if len(route) == 7:
            result.add(route)
            continue
        for i in range(4):
            cx, cy = now[0] + dx[i], now[1] + dy[i]
            if cx >= 4 or cx < 0 or cy >= 4 or cy < 0:
                continue
            q.append(((cx, cy), route+str(graph[cx][cy])))

for test_case in range(1, T + 1):
    graph = [list(map(int, input().split())) for _ in range(4)]
    result = set()
    for i in range(4):
        for j in range(4):
            bfs(result, graph, (i, j))
    print(f"#{test_case} {len(result)}")