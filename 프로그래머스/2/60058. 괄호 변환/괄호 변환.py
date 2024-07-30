def solution(p):
    return recursive(p)
    
def recursive(p):
    # 빈 문자열인 경우 그대로 반환
    if len(p) == 0:
        return ""
    # p를 순회하며, u와 v로 분리
    u, v = decomposition(p)
    
    # u 가 올바른 괄호 문자열인지 확인
    if check(u):
        # 맞으면, u + recursive(v)
        return u + recursive(v)
    else:
        # 아니면, ( + recursive(v) + ) + reverse(u[1:-1])
        return "(" + recursive(v) + ")" + reverse(u[1:-1]) 

def check(p):
    stack = []
    for i in range(len(p)):
        if p[i] == '(':
            stack.append('(')
        else:
            if len(stack) == 0:
                return False
            else:
                stack.pop()
    return True
    
def decomposition(p):
    start = p[0]
    tmp = 1
    
    split_index = 0
        
    for i in range(1,len(p)):
        if p[i] == start:
            tmp += 1
        else:
            tmp -= 1
        if tmp == 0:
            split_index = i
            break
    
    u = p[:i+1]
    v = p[i+1:]
    
    return u, v

def reverse(u):
    output = ""
    for w in u:
        if w == "(":
            output += ")"
        else:
            output += "("
    return output