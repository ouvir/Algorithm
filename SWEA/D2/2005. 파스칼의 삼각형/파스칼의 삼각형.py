T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    pascal_list = [[0] * N for _ in range(N)]
    for i in range(N):
    	pascal_list[i][0] = 1
    
    for i in range(1, N):
        for j in range(1, N):
        	pascal_list[i][j] = pascal_list[i-1][j-1] + pascal_list[i-1][j]

    print(f"#{test_case}")
    for i in range(N):
        for j in range(N):
            if pascal_list[i][j] == 0:
                break
            print(pascal_list[i][j], end=" ")
        print()