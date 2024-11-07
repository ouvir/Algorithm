import sys
input = sys.stdin.readline

def check(graph, data):
    for i in range(5):
        for j in range(5):
            if graph[i][j] == data:
                graph[i][j] = 0
                return

def check_bingo(graph):
    graph_col = list(map(list, zip(*graph)))

    bingo = 0
    # 가로 체크
    for i in range(5):
        if sum(graph[i]) == 0:
            bingo += 1
    # 세로 체크
    for i in range(5):
        if sum(graph_col[i]) == 0:
            bingo += 1

    # 대각선 체크
    tmp_a = 0
    tmp_b = 0
    for i in range(5):
        tmp_a += graph[i][i]
        tmp_b += graph[i][4-i]
    if tmp_a == 0:
        bingo += 1
    if tmp_b == 0:
        bingo += 1

    return bingo

graph = [list(map(int,input().split())) for _ in range(5)]


count = 0
play = True
for _ in range(5):
    data = list(map(int, input().split()))

    if play:
        for d in data:
            count += 1
            check(graph, d)
            if check_bingo(graph) >= 3:
                play = False
                break
print(count)