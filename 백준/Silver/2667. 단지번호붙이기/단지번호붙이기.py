import sys

N = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().rstrip())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def dfs(graph, visited, v, count):
    x, y = v[0], v[1]
    visited[x][y] = True
    
    for i in range(4):
        cx, cy = x + dx[i], y + dy[i]
        if cx >= N or cx < 0 or cy >= N or cy < 0:
            continue
        if graph[cx][cy] and not visited[cx][cy]:
            count = dfs(graph, visited, [cx, cy], count+1)
    return count

output = []
for i in range(N):
    for j in range(N):
        if graph[i][j] and not visited[i][j]:
            output.append(dfs(graph, visited, [i,j], 1))
output.sort()

print(len(output))
for o in output:
    print(o)