'''
문제 풀이
전체 탐색 -> 1문제당 2가지의 경우의 수 나옴 -> 최대 2^100 나옴
여기서 중복 탐색을 제거해야 함.
무엇이 중복되는가? 
예)  10 / 1 1 1 1 1 1 1 1 1 1 에서, 
1번문제를 틀리고 2번문제를 맞춘 경우와 1번문제를 맞추고 2번문제를 틀린경우는 같은 경우로 취급 가능
-> 이를 더 확대하면, 1~5를 모두 맞춘 케이스와 6~10 을 모두 맞춘 케이스는 같은 경우임
dp에 저장하면서 나아갈 것? > dp[i] 에 가능한 케이스 점수를 저장
i는 문제수를 늘려가기
최종 출력으로 len(dp[N]) 하면 경우의 수가 나옴 

시간복잡도: O(N^2)
'''

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    score = list(map(int, input().split()))
    dp = [set() for _ in range(N+1)]
    dp[0].add(0)
    for i in range(1, N+1):
        for s in dp[i-1]:
            dp[i].add(s + score[i-1])
            dp[i].add(s)
    print(f"#{test_case} {len(dp[N])}")