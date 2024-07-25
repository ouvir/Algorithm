from collections import deque

def solution(people, limit):
    people.sort()
    q = deque(people)
    
    count = 0
    
    while q:
        if len(q) == 1:
            q.pop()
            count += 1
            break
        front = q.popleft()
        back = q.pop()
        
        if front + back > limit:
            count += 1
            q.appendleft(front)
        else:
            count += 1
    
    return count