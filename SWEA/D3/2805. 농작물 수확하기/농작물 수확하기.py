T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    graph = [list(map(int, input())) for _ in range(N)]
    
    output = 0
    for i in range(N//2): #N= 3, i = 0
        output += sum(graph[i][N//2 - i : N//2 + i + 1])
    output += sum(graph[N//2]) # N = 3

    for i in range(N//2 + 1, N): #N= 3, i = 2
        temp = N - i - 1
        output += sum(graph[i][N//2 - temp : N//2 + temp + 1])
    print(f"#{test_case} {output}")