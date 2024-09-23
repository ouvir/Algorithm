from collections import deque
N = int(input())
data = list(map(int, input().split()))

stack = []
students = deque(data)
index = 1

while students:
    student = students.popleft()
    
    if stack:
        student_B = stack[-1]
        if student == index:
            index += 1
        elif student_B == index:
            stack.pop()
            students.appendleft(student)
            index += 1
        else:
            stack.append(student)
    else:
        if student == index:
            index += 1
        else:
            stack.append(student)

while stack:
    student = stack.pop()
    if student == index:
        index += 1
    else:
        break

if index == N+1:
    print("Nice")
else:
    print("Sad")