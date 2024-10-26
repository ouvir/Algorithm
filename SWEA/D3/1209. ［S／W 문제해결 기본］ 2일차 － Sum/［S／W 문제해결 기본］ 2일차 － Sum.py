T = 10
for test_case in range(1, T + 1):
    tc = int(input())
    graph = [list(map(int, input().split())) for _ in range(100)]
    
    output = 0
    # 가로
    for i in range(100):
        output = max(sum(graph[i]), output)
    # 세로
    for i in range(100):
        tmp = 0
        for j in range(100):
            tmp += graph[j][i]
        output = max(tmp, output)
    # 대각선
    tmp = 0
    for i in range(100):
        tmp += graph[i][i]
    output = max(tmp, output)
    tmp = 0
    for i in range(100):
        tmp += graph[i][99-i]
    output = max(tmp, output)
    print(f"#{test_case} {output}")