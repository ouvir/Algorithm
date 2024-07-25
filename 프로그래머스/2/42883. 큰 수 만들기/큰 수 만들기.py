def solution(number, k):
    stack = []
    for n in number:
        if len(stack) == 0 or k == 0 or int(n) <= stack[-1]:
            stack.append(int(n))
        else:
            while stack and stack[-1] < int(n):
                stack.pop()
                k -= 1
                if k == 0:
                    break
            stack.append(int(n))
            
    while k != 0:
        k -= 1
        stack.pop()
        
    answer = ""
    for n in stack[:]:
        answer += str(n)
    return answer