# BFS를 통해, visited가 아닌 애들 순회하면서, 지렁이 수 count하기
# queue 에 배추 담기
# 배추 탐색하며 지렁이 수 추가
import sys
from collections import deque
input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    graph = [[0] * M for _ in range(N)]
    visited = [[False] * M for _ in range(N)]
    position = []
    for i in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1
        position.append((x, y))

    def bfs(graph, visited, x, y):
        q = deque()
        q.append((x, y))

        while q:
            x, y = q.popleft()

            for i in range(4):
                cx, cy = x + dx[i], y + dy[i]
                if cx >= M or cx < 0 or cy >= N or cy < 0:
                    continue
                if graph[cy][cx] == 0:
                    continue
                if not visited[cy][cx]:
                    visited[cy][cx] = True
                    q.append((cx, cy))

    count = 0 # 지렁이 개수
    for p in position:
        x, y = p
        if not visited[y][x]:
            bfs(graph, visited, x, y)
            count += 1
    print(count)