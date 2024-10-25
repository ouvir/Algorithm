# 8*8 격자판
# 글자 수 N
# N이 짝수 -> 모두 검사
# N이 홀수 -> 가운데 빼고 검사
# N = 4 -> 한줄당 5개 (8 - 4 + 1 ) * 8 줄 * 2(가로 세로) = 80 개 경우의 수 모두 체크
# N 최소값 -> 2라고 가정 -> 112개 경우의 수
# 112 * O(한개의 케이스가 회문인지 체크하는 시간복잡도)
# 회문 검사 : N의 절반 크기 리스트에 값 넣고 맞는지 확인 -> O(N)
# 112 * O(N) = O(N)

T = 10
def checkCycle(words):
    N = len(words)
    half = N // 2
    tmp = [" "] * half
    
    for i in range(half):
            tmp[i] = words[i]
    
    if N % 2 == 1:
        for i in range(half+1, N): #3, 4
            if tmp[half - (i - half)] != words[i]: # 1, 0 -> 3, 4 비교
                return False
    else:
        for i in range(half, N): #2, 3
            if tmp[half - (i - half + 1)] != words[i]: # 1, 0 -> 2, 3 비교
                return False
    return True

for test_case in range(1, T + 1):
    N = int(input())
    graph = [list(map(str, input())) for _ in range(8)]
    output = 0
    for i in range(8):
        for j in range(8 - N + 1):
            if checkCycle(graph[i][j:j+N]):
                output += 1
            
    for i in range(8):
        for j in range(8 - N + 1):
            words = []
            for line in graph[j:j+N]:
                words.append(line[i])
            if checkCycle(words):
                output += 1
                
    print(f"#{test_case} {output}")