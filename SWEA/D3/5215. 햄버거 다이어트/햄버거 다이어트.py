T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
	N, L = map(int, input().split())
	items = [[0, 0]]
	dp = [[0] * (L+1) for _ in range(N+1)] # 최대 이익을 저장
    
	for i in range(N):
		items.append(list(map(int, input().split()))) # score, calorie
    
	for i in range(1, N+1):
		for j in range(1, L+1): #dp[i][j] = i번째 물건까지 있고, j 용량  만큼 담을 수 있을 때 최대 가치
			weight = items[i][1]
			value = items[i][0]
			if j < weight: 
				dp[i][j] = dp[i-1][j]
			else:
				dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight] + value)
	print(f"#{test_case} {dp[N][L]}")