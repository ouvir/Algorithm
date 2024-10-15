import sys
import copy
from collections import deque

input = sys.stdin.readline

# BFS를 통한, (모든 애들 합, 칸의 수) 저장
# 이를 통해, 각 칸의 재분배 시도(조건1. 차이가 L<= x <=R 여야함)
# 더이상 변경이 없을 때까지 반복
# graph, tmp : 각 칸의 인구 저장
N, L, R = map(int, input().split())

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def check(graph: list, tmp: list):
    # 두개의 2차원 리스트가 같은지 체크하는 함수
    for i in range(N):
        for j in range(N):
            if graph[i][j] != tmp[i][j]:
                return False
    return True

def bfs(graph: list, visited: list, pos: set):
    output = []
    output.append(pos)
    
    result = 0
    
    visited[pos[0]][pos[1]] = True
    
    q = deque()
    q.append(pos)
    
    while q:
        x, y = q.popleft()
        result += graph[x][y]
        
        for i in range(4):
            cx, cy = x + dx[i] , y + dy[i]
            if cx >= N or cx < 0 or cy >= N or cy < 0:
                continue
            diff = abs(graph[cx][cy] - graph[x][y])
            if (diff >= L) and (diff <= R) and (visited[cx][cy] == False):
                q.append((cx, cy))
                output.append((cx, cy))
                visited[cx][cy] = True
    return [output, result]

graph = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * (N) for _ in range(N)]
tmp = copy.deepcopy(graph)
count = 0

while True:
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                group, result = bfs(graph, visited, (i, j))
                g_value = result // len(group)
                for x, y in group:
                    tmp[x][y] = g_value
    
    if check(graph, tmp): # 인구 이동이 변화가 없다면 그만
        break
    
    graph = copy.deepcopy(tmp)
    visited = [[False] * (N) for _ in range(N)]
    count += 1

print(count)