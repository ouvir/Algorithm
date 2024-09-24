from collections import deque

def solution(priorities, location):
    answer = 1
    queue = deque(priorities)
    max_priority = max(queue)
    
    while queue:
        priority = queue.popleft()
        # 한 프로세스가 수행되는 경우
        if priority >= max_priority:
            if location == 0:
                return answer
            answer += 1
            max_priority = max(queue)
        
        # 수행되지 않는 경우
        else:
            queue.append(priority)
        
        # target 프로세스의 index가 줄어듦
        location -= 1
        # target 프로세스가 맨 뒤로 보내진 경우
        if location < 0:
            location = len(queue) - 1

    return answer