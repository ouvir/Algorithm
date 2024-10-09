import sys
from collections import deque
input = sys.stdin.readline

N, K = map(int, input().split())

belt = deque(list(map(int, input().split())))

robot = deque([0] * N)

def can_move(idx):
	return belt[idx] > 0

def rotate_belt():
    # rotate belt
    belt.rotate(1)
    
    # robot도 벨트와 같이 이동됨
    robot.rotate(1)
    
	# 마지막 칸 로봇 내리기
    robot[N-1] = 0
	
def robot_move():
    for i in range(N-2, -1, -1):
        if robot[i] and not robot[i+1] and can_move(i+1):
            robot[i], robot[i+1] = 0, 1
            belt[i+1] -= 1
    
	# 마지막 칸 로봇 내리기
    robot[N-1] = 0
    
def new_robot():
    if can_move(0):
        robot[0] = 1
        belt[0] -= 1 # 내구도 감소

def check_count():
    count = 0
    for i in range(2*N):
        if not can_move(i):
            count += 1
    if count >= K:
        return True
    else:
        return False

output = 1
while True:
    rotate_belt()
    robot_move()
    new_robot()

    if check_count():
        break
    else:
        output += 1
print(output)