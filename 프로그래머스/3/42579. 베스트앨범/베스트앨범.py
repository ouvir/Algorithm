def solution(genres, plays):
    dict1 = dict()
    dict2 = dict()
    
    for i in range(len(genres)):
        # dict1 업데이트
        if genres[i] in dict1:
            dict1[genres[i]] += plays[i]
        else:
            dict1[genres[i]] = plays[i]
            
        # dict2 업데이트
        if genres[i] in dict2:
            # 비교
            dict2[genres[i]].append((plays[i],i))
            dict2[genres[i]].sort(key= lambda x:x[0], reverse=True)
            while len(dict2[genres[i]]) > 2:  
                dict2[genres[i]].pop()
        else:
            # 추가
            dict2[genres[i]] = []
            dict2[genres[i]].append((plays[i],i))
    
    items = list(dict1.items())
    items.sort(key=lambda x: x[1], reverse=True)
    
    answer = []   
    
    for key, value in items:
        for item in dict2[key]:
            answer.append(item[1])
        
    return answer