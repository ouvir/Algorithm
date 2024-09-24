def solution(progresses, speeds):
    answer = []
    index = 0 # 배포를 위해 완료되어야하는 첫번째 작업의 index
    count = 0 # 이번 배포에서 완료된 작업의 수
    
    N = len(progresses)
    while index < N:
        # 작업 진행
        for i in range(N):
            progresses[i] += speeds[i]
            
        # 완료된 작업이 있다면 배포
        if progresses[index] >= 100:
            for i in range(index, N):
                if progresses[i] >= 100:
                    count += 1
                else:
                    break
            index += count
            
            answer.append(count)        
            count = 0
            
    return answer