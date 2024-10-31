# stack 자료구조 이용 문제
# 앞에서부터 진행하면서, stack의 top과 현재 number 가 같으면 stack top 제거

T = 10
for test_case in range(1, T + 1):
    data = list(map(str, input().split()))
    N = data[0]
    numbers = data[1]
    
    stack = []
    for n in numbers:
        if not stack or stack[-1] != n:
            stack.append(n)
            continue
        stack.pop()
    output = "".join(stack)
    print(f"#{test_case} {output}")