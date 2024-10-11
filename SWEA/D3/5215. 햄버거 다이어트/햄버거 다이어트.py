T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
	N, L = map(int, input().split())
	items = [[0,0]] # score, calorie
	for _ in range(N):
		items.append(list(map(int, input().split())))
	dp = [[0] * (L+1) for _ in range(N+1)] # i번째 까지 item들로 만들어낼 수 있는 최고 점수
    
	for i in range(1, N+1):
		for j in range(1, L+1):
			v, w = items[i]
			if j < w:
				dp[i][j] = dp[i-1][j]
			else:
				dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + v)
	print(f"#{test_case} {dp[N][L]}")