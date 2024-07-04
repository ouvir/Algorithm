import sys
from collections import deque
import copy

case = int(sys.stdin.readline())
outputs = []
for _ in range(case):
    N, M = map(int, sys.stdin.readline().split())
    priority = deque(list(map(int,sys.stdin.readline().split())))
    count = 1
    while priority:
        currDoc = priority.popleft()
        for doc in copy.deepcopy(priority):
            if doc > currDoc: # 내꺼보다 중요한 문서 존재 > 뒤에 넣어줌
                priority.append(currDoc)
                if M == 0: # 현재 문서가 내가 추적하는 문서라면
                    M = len(priority) - 1
                else:
                    M -= 1
                break    
        else: # 내꺼가 제일 중요해 > 출력
            if M == 0:
                break
            else:
                count += 1
                M -= 1
    outputs.append(count)

for output in outputs:
    print(output)