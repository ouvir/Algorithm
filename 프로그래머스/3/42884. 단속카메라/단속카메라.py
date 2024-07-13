def solution(routes):
    routes.sort(key= lambda x: x[0])
    
    answer = len(routes)
    endPoint = -30001
    for route in routes:
        if endPoint >= route[0]:
            answer -= 1
            endPoint = min(endPoint, route[1])
        else:
            endPoint = route[1]
    
    return answer