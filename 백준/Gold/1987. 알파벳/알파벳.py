import sys

R, C = map(int, sys.stdin.readline().split())

Map = []
visited = [0] * 26

for _ in range(R):
    Map.append(list(map(str,sys.stdin.readline().rstrip())))
    
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def dfs(pos, count):
    output = count
    for i in range(4):
        cx, cy = pos[0] + dx[i], pos[1] + dy[i]
        if cx < 0 or cx >= R or cy < 0 or cy >= C:
            continue
        if visited[ord(Map[cx][cy]) - 65] == 0:
            visited[ord(Map[cx][cy]) - 65] = 1
            c = dfs((cx,cy), count + 1)
            visited[ord(Map[cx][cy]) - 65] = 0
            output = c if c > output else output
    return output 

visited[ord(Map[0][0])-65] = 1
print(dfs((0,0), 1))