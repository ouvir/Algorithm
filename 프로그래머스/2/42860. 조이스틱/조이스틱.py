def solution(name):
    count = []
    
    for n in name:
        up_count = abs(ord(n) - ord('A'))
        down_count = abs(ord('Z') - ord(n)) + 1
        tmp = up_count if up_count < down_count else down_count
        count.append(tmp)
        
    min_move = len(name) - 1
    
    for i in range(len(name)):
        # 해당 알파벳 다음부터 연속된 A 문자열 end index 찾기
        next = i + 1
        while next < len(name) and name[next] == 'A':
            next += 1
            
        # 기존, 연속된 A 왼쪽 방식, 연속된 A 오른쪽 방식 비교 > 업데이트
        right_start_A = i + (len(name) - next) * 2
        left_start_A = i * 2 + len(name) - next
        min_move = min([min_move, left_start_A, right_start_A])
    
    answer = sum(count) + min_move 
    return answer