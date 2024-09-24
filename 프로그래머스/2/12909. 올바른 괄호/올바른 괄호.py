def solution(s):
    answer = True
    stack = []

    for c in s:
        if c == '(':
            stack.append(c)
        elif not stack:
            answer = False
            break
        else:
            stack.pop()
    if stack:
        answer = False
    return answer