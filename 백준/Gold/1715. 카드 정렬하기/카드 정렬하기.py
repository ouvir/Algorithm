import sys
from collections import deque

N = int(sys.stdin.readline())

data = [int(sys.stdin.readline()) for _ in range(N)]

data.sort()

dataQueue = deque()

for d in data:
    dataQueue.append(d)

saveQueue = deque()

result = 0
while dataQueue or saveQueue:
    if dataQueue and saveQueue:
        if dataQueue[0] < saveQueue[0]:
            a = dataQueue.popleft()
        else:
            a = saveQueue.popleft()
        if not dataQueue:
            b = saveQueue.popleft()
        elif not saveQueue:
            b = dataQueue.popleft()
        elif dataQueue[0] < saveQueue[0]:
            b = dataQueue.popleft()
        else:
            b = saveQueue.popleft()
    elif len(dataQueue) == 1:
        dataQueue.popleft()
        a = 0
        b = 0
    elif len(saveQueue) == 1:
        break
    elif dataQueue:
        a = dataQueue.popleft()
        b = dataQueue.popleft()
    else:
        a = saveQueue.popleft()
        b = saveQueue.popleft()
        
    result += a + b
    saveQueue.append(a + b)

print(result)