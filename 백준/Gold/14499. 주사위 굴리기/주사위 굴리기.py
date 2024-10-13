# 주사위 면 -> dict() 로 설계
# dice['now'], dice['up'], dice['down'], dice['right'], dice['left'], dice['floor']
import sys
input = sys.stdin.readline

N, M, x, y, K = map(int,input().split())

# graph[0][0] ~ graph[N-1][M-1]
graph = [list(map(int, input().split())) for _ in range(N)]

orders = list(map(int, input().split()))

dice = dict()

dx = [0, 0, 0, -1, 1]
dy = [0, 1, -1, 0, 0]

dice['now'] = 0
dice['up'] = 0
dice['down'] = 0
dice['right'] = 0
dice['left'] = 0
dice['floor'] = 0

for o in orders:
    cx, cy = x + dx[o], y + dy[o]    
    if cx < 0 or cx >= N or cy < 0 or cy >= M:
        continue
    # 주사위 이동
    x, y = cx, cy
    tmp = dice['now']
    if o == 1:
        dice['now'] = dice['right']
        dice['right'] = dice['floor']
        dice['floor'] = dice['left']
        dice['left'] = tmp
    elif o == 2:
        dice['now'] = dice['left']
        dice['left'] = dice['floor']
        dice['floor'] = dice['right']
        dice['right'] = tmp
    elif o == 3:
        dice['now'] = dice['down']
        dice['down'] = dice['floor']
        dice['floor'] = dice['up']
        dice['up'] = tmp
    elif o == 4:
        dice['now'] = dice['up']
        dice['up'] = dice['floor']
        dice['floor'] = dice['down']
        dice['down'] = tmp
        
    # 주사위 값 복사 or 지도 값 복사
    if graph[x][y] ==  0:
        graph[x][y] = dice['floor']
    else:
        dice['floor'] = graph[x][y]
        graph[x][y] = 0
    # 맨 위 값 출력
    print(dice['now'])