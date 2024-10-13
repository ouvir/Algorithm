import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
K = int(input())
graph = [[0] * (N) for _ in range(N)]
for _ in range(K):
    x, y = map(int, input().split())
    graph[x-1][y-1] = 1
L = int(input())
move = dict() # move[time] = direction

for _ in range(L):
    data = list(map(str, input().rstrip().split()))
    move[int(data[0])] = data[1]

time = 0
snake = deque()
snake.append((0,0))

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
d = 1

# init
graph[0][0] = 2
while True:
    time += 1
    
    x, y = snake[0]
    cx, cy = x + dx[d] , y + dy[d]
    
    if cx >= N or cy >= N or cx < 0 or cy < 0:
        break
    if graph[cx][cy] == 2: # 자기 자신과 부딪힌 경우
        break
        
    if graph[cx][cy] != 1: # 사과 칸이 아니면 꼬리 줄이기
        tail_x, tail_y = snake.pop()
        graph[tail_x][tail_y] = 0
        
    # 머리칸 추가    
    graph[cx][cy] = 2    
    snake.appendleft((cx,cy))
    
    if time in move:
        if move[time] == 'L':
            d += 1
        elif move[time] == 'D':
            d -= 1
            d += 4
        d %= 4
print(time)