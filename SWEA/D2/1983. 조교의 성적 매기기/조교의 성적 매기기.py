T = int(input())
grade = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D-"]
for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    total_score = []
    sorted_total_score = []
    
    for _ in range(N):
        m, f, h = map(int, input().split())
        total_score.append(m * 35 + f * 45 + h * 20)
    
    sorted_total_score = sorted(total_score,reverse=True)
    total_grade = sorted_total_score.index(total_score[K-1])
    
    print(f"#{test_case} {grade[total_grade // (N // 10)]}")