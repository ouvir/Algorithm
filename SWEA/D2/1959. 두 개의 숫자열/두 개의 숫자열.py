T = int(input())

def find(small_list, big_list):
    n, m = len(small_list), len(big_list)
    
    result = 0
    for i in range(m-n+1):
        tmp = 0
        for j in range(n):
            tmp += small_list[j] * big_list[i+j]
        result = max(result, tmp)
    return result

for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    
    output = 0
    if N <= M:
        output = find(A, B)
    else:
        output = find(B, A)
    print(f"#{test_case} {output}")