import sys
from collections import deque
import copy

N, M = map(int, sys.stdin.readline().split())

Map = []

for _ in range(N):
    Map.append(list(map(int, sys.stdin.readline().split())))

c = N * M

output = 0


dx = [1,0,-1,0]
dy = [0,1,0,-1]

def bfs(Map, b1, b2, b3):
    copy_map = copy.deepcopy(Map)

    copy_map[b1[0]][b1[1]] = 1
    copy_map[b2[0]][b2[1]] = 1
    copy_map[b3[0]][b3[1]] = 1

    queue = deque()
    for i in range(len(copy_map)):
        for j in range(len(copy_map[0])):
            if copy_map[i][j] == 2:
                queue.append((i,j))

    while queue:
        x,y = queue.popleft()
        
        for i in range(4):
            cx, cy = x + dx[i], y + dy[i]
            if cx < 0 or cx >= N or cy < 0 or cy >= M:
                continue
            if copy_map[cx][cy] == 0:
                copy_map[cx][cy] = 2
                queue.append((cx, cy))
    
    count = 0
    for i in range(len(copy_map)):
        for j in range(len(copy_map[0])):
            if copy_map[i][j] == 0:
                count += 1
    return count

for i in range(c):
    for j in range(i+1,c):
        for k in range(j+1,c):
            block_1, block_2 , block_3 = (i // M,i % M), (j // M,j % M), (k // M,k % M)

            if Map[block_1[0]][block_1[1]] != 0 or Map[block_2[0]][block_2[1]] != 0 or Map[block_3[0]][block_3[1]] != 0:
                continue
            count = bfs(Map, block_1, block_2, block_3)
            output = count if count > output else output

print(output)