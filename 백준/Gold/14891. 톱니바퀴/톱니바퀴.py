# 각 톱니의 12시 방향 저장 > 이를 통해, 양 옆 방향 구하기 가능
import sys
input = sys.stdin.readline

def rotate_cycle(visited, cycles, cycle_index, cycle_12_index, direction):
    curr_index_12 = cycle_12_index[cycle_index]
    
    # 현재 톱니의 양옆 톱니 회전
    curr_cycle = cycles[cycle_index]
    prev_i = cycle_index - 1
    next_i = cycle_index + 1
    left_index = (curr_index_12 + 6) % 8
    right_index = (curr_index_12 + 2) % 8
    if (prev_i >= 0) and (not visited[prev_i]):
        prev_cycle = cycles[prev_i]
        prev_right_index = (cycle_12_index[prev_i] + 2) % 8
        if (curr_cycle[left_index] != prev_cycle[prev_right_index]):
            visited[prev_i] = True
            rotate_cycle(visited, cycles, prev_i, cycle_12_index, direction*(-1))
    
    if (next_i <= 3) and (not visited[next_i]):
        next_cycle = cycles[next_i]
        next_left_index = (cycle_12_index[next_i] + 6) % 8
        if (curr_cycle[right_index] != next_cycle[next_left_index]):
            visited[next_i] = True
            rotate_cycle(visited, cycles, next_i, cycle_12_index, direction*(-1))
    
    # 현재 사이클 회전
    if direction == 1:
        curr_index_12 += 8
        curr_index_12 -= 1
    else:
        curr_index_12 += 1
    curr_index_12 %= 8
    
    cycle_12_index[cycle_index] = curr_index_12
    return

cycles = []
cycle_12_index = []
for _ in range(4):
    data = list(map(int, input().rstrip()))
    cycles.append(data)
    cycle_12_index.append(0)

K = int(input())
for _ in range(K):
    index, d = map(int, input().split())
    index -= 1
    visited = [False] * (4)
    rotate_cycle(visited, cycles, index, cycle_12_index, d)
output = 0
for i in range(4):
    if cycles[i][cycle_12_index[i]] == 1:
        output += 2 ** i
print(output)