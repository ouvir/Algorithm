def solution(clothes):
    hash = dict()

    for cloth in clothes: 
        if cloth[1] in hash:
            hash[cloth[1]] += 1
        else:
            hash[cloth[1]] = 1

    multiple = 1

    for i in hash.values():
        multiple *= (i+1) # 안고르는 경우 추가


    answer = multiple -1 # 모두 안고르는 경우 제외
    return answer