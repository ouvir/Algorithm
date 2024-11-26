from collections import deque

N = int(input())

numbers = [i for i in range(1, N+1)]

q = deque(numbers)

while q:
    now = q.popleft() # 한 개 빼서 버리기
    print(now, end=" ")

    if q:
        second = q.popleft() # 2번째 빼서 맨 뒤에 넣기
        q.append(second)