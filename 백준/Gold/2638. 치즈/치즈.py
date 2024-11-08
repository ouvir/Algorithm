# DFS로 외부 공기를 탐색
# 만약 치즈를 만나면, 만난 횟수 업데이트
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

N, M = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]

def dfs(graph, visited, position):
    x, y = position
    if graph[x][y] == 0:
        visited[x][y] = True

    if graph[x][y] > 0:
        graph[x][y] -= 1
        if graph[x][y] == 0:
            visited[x][y] = True
        return

    for i in range(4):
        cx, cy = x + dx[i], y + dy[i]
        if cx >= N or cx < 0 or cy >= M or cy < 0:
            continue
        if visited[cx][cy]:
            continue
        dfs(graph, visited, (cx,cy))

count = 0
while True:
    cheese = False
    visited = [[False] * (M) for _ in range(N)]
    # 치즈의 닿는 면을 표시하기 위해 2로 변경
    for i in range(N):
        for j in range(M):
            if graph[i][j] > 0:
                graph[i][j] = 2
                cheese = True
    if not cheese:
        break
        
    # 외부 공기부터 탐색해서, 방문횟수만큼 치즈 빼기(2면이 닿은 경우 0이 되어 녹음)
    dfs(graph, visited, (0, 0))

    count += 1

print(count)