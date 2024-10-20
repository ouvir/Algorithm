T = int(input())

def make90(graph):
    n = len(graph)
    output = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            output[j][n-1-i] = graph[i][j]
    return output

for test_case in range(1, T + 1):
    N = int(input())
    graph = [list(map(int, input().split())) for _ in range(N)]
    graph_90 = make90(graph)
    graph_180 = make90(graph_90)
    graph_270 = make90(graph_180)
    
    print(f"#{test_case}")
    for i in range(N):
        for j in range(N):            
            print(graph_90[i][j], end='')
        print(" ", end='')
        for j in range(N): 
            print(graph_180[i][j], end='')
        print(" ", end='')
        for j in range(N):
            print(graph_270[i][j], end='')
        print()