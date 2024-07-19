def zipper(S, r):
    output = len(S)
    count = 1
    tmp = S[0:r]
    zipped = ""
    
    for i in range(r, len(S), r):
        if tmp == S[i : i + r]:
            count += 1
            
        else:
            zipped += str(count) + tmp if count > 1 else tmp 
            count = 1
            tmp = S[i: i + r]
    
    zipped += str(count) + tmp if count > 1 else tmp
    return len(zipped)

def solution(s):
    answer = len(s)
    for i in range(1, len(s) // 2 + 1):
        length = zipper(s, i)
        if answer > length:
            answer = length
    return answer