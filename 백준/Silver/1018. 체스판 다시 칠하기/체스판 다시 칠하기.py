import sys

def check_board(board_list):
    fix_count_B = 0
    fix_count_W = 0
    for i in range(8):
        for j in range(8):
            if i % 2 ==  j % 2 and board_list[i][j] == 'W': fix_count_B += 1
            elif i % 2 != j % 2 and board_list[i][j] == 'B': fix_count_B += 1
            elif  i % 2 ==  j % 2 and board_list[i][j] == 'B': fix_count_W += 1
            elif i % 2 != j % 2 and board_list[i][j] == 'W': fix_count_W += 1

    if fix_count_B <= fix_count_W:
        return fix_count_B
    else:
        return fix_count_W

N,M = map(int,sys.stdin.readline().split())

board = [sys.stdin.readline().rstrip() for i in range(N)]
min_fix = 64
break_value = False
for i in range(N-7):
    board_fix = board[i:8+i] 
    for j in range(M-7): 
        for k in range(8): 
            board_fix[k] = board[k+i][j:8+j]
        # 모든 경우의 수 만큼 짜르기 성공
        count = check_board(board_fix)
        if min_fix > count: # 전부 실행해서 가장 최소의 값 찾기
            min_fix = count
        if count == 0:
            min_fix = count
            break_value = True
            break
    if break_value:
        break
print(min_fix)