T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    graph = [list(map(int, input().split())) for _ in range(N)]
    
    max_count = 0
    for i in range(N-M+1):
        for j in range(N-M+1):
            count = 0
            for t_i in range(M):
                for t_j in range(M):
                    count += graph[i+t_i][j+t_j]
            max_count = max(max_count, count)
    print(f"#{test_case} {max_count}")