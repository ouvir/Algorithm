def count_sort(graph):
    max_len = 0
    for i in range(100):
        output = dict()
        for j in range(100):
            if graph[i][j] == 0:
                continue
            if graph[i][j] in output:
                output[graph[i][j]] += 1
            else:
                output[graph[i][j]] = 1
        temp = list(output.items())
        temp.sort(key=lambda x: (x[1], x[0]))
        idx = 0

        for t in temp:
            graph[i][idx] = t[0]
            graph[i][idx+1] = t[1]
            idx += 2
        for k in range(idx, 100):
            graph[i][k] = 0
        max_len = max(max_len, idx)
    return max_len

def count_sort_col(graph):
    max_len = 0
    for i in range(100):
        output = dict()
        for j in range(100):
            if graph[j][i] == 0:
                continue
            if graph[j][i] in output:
                output[graph[j][i]] += 1
            else:
                output[graph[j][i]] = 1
        temp = list(output.items())
        temp.sort(key=lambda x: (x[1], x[0]))
        idx = 0
        for t in temp:
            graph[idx][i] = t[0]
            graph[idx+1][i] = t[1]
            idx += 2
        for k in range(idx, 100):
            graph[k][i] = 0
        max_len = max(max_len, idx)
    return max_len

import sys
input = sys.stdin.readline

R, C, K = map(int, input().split())
R -= 1
C -= 1


graph = [[0] * 100 for _ in range(100)]

for i in range(3):
    data = list(map(int, input().split()))
    for j in range(3):
        graph[i][j] = data[j]

count = 0
r_length = 3 # 세로 길이
c_length = 3 # 가로 길이

while True:
    if count > 100:
        count = -1
        break
    if graph[R][C] == K:
        break
    if r_length >= c_length: # R연산(가로 연산)
        c_length = count_sort(graph)
    else: # C연산(세로 연산)
        r_length = count_sort_col(graph)
    count += 1

print(count)