T = int(input())
for test_case in range(1, T + 1):
    string = list(map(str, input()))
    stack = []
    flag = 1
    N = len(string) # 5 - > 2 , 4 -> 2
    for i in range(N//2): # 0, 1
        stack.append(string[i])
    for i in range(N-1, N - N//2 - 1, -1): # 5-> 4,3 4-> 3, 2
        if string[i] != stack[N - i - 1]:
            flag = 0
            break
    print(f"#{test_case} {flag}")