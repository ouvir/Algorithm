import sys

testCase = int(sys.stdin.readline())

for _ in range(testCase):
    N = int(sys.stdin.readline())
    applicants = []
    for i in range(N):
        applicants.append(list(map(int,sys.stdin.readline().split())))

    applicants.sort(key=lambda x: x[0])
    rank_1 = 100001
    rank_2 = 100001
    count = N

    for applicant in applicants:
        if applicant[0] > rank_1 and applicant[1] > rank_2:
            count -= 1
        else:
            rank_1 = applicant[0] if applicant[0] < rank_1 else rank_1
            rank_2 = applicant[1] if applicant[1] < rank_2 else rank_2
    print(count)