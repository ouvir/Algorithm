import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

numbers = list(map(int, input().split()))

plus, minus, multiple, division = map(int, input().split())

q = deque()

max_num = int(1e10) * -1
min_num = int(1e10)

q.append((numbers[0], (plus, minus, multiple, division))) 
# 시작 숫자, (더하기, 빼기, 곱하기, 나누기)

while q:
    number, operator = q.popleft()
    
    index = N - sum(operator)

    if index == N:
        max_num = number if number > max_num else max_num
        min_num = number if number < min_num else min_num 
        continue

    for i in range(4):
        tmp = number
        if operator[i] == 0:
            continue
        
        if i == 0:
            tmp += numbers[index]
            q.append((tmp, (operator[0] - 1, operator[1], operator[2], operator[3])))
        elif i == 1:
            tmp -= numbers[index]
            q.append((tmp, (operator[0], operator[1] - 1, operator[2], operator[3])))
        elif i == 2:
            tmp *= numbers[index]
            q.append((tmp, (operator[0], operator[1], operator[2] - 1, operator[3])))
        else:
            if tmp > 0 :
                tmp //= numbers[index]
            else:
                tmp *= -1
                tmp //= numbers[index]
                tmp *= -1
            q.append((tmp, (operator[0], operator[1], operator[2], operator[3] - 1)))

print(max_num)
print(min_num)