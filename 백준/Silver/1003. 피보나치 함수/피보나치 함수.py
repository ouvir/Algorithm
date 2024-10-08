def count_fibo(N):
    global memo
    
    output = [0, 0]
    if N == 0:
        output[0] += 1
    elif N == 1:
        output[1] += 1 
    else:
        if N-1 in memo:
            tmp_a = memo[N-1]
        else:
            tmp_a = count_fibo(N-1)
            memo[N-1] = tmp_a
        if N-2 in memo:
            tmp_b = memo[N-2]
        else:
            tmp_b = count_fibo(N-2)
            memo[N-2] = tmp_b
        output[0] += tmp_a[0]
        output[0] += tmp_b[0]
        output[1] += tmp_a[1]
        output[1] += tmp_b[1]
    return output

T = int(input())

for test_case in range(T):
    N = int(input())
    memo = dict()
    output = count_fibo(N)
    print(*output)