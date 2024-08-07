def solution(N, number):
    dp = [set() for _ in range(8)]
    
    # N을 붙여 만드는 숫자 추가
    for i, s in enumerate(dp):
        s.add(int(str(N) * (i+1)))
    
    # i: N을 사용할 개수, j: dp[i] 에 추가할 dp[N-j] (사칙연산) dp[j] 의 기준
    for i in range(8):
        for j in range(i):
            for num1 in dp[j]:
                for num2 in dp[i-j-1]:
                    dp[i].add(num1 + num2)
                    dp[i].add(num1 - num2)
                    dp[i].add(num1 * num2)
                    if num2 != 0:
                        dp[i].add(num1 // num2)
        
        if number in dp[i]:
            return i + 1
    return -1