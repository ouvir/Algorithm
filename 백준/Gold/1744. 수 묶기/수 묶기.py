import sys
input = sys.stdin.readline

N = int(input())

numbers = [int(input()) for _ in range(N)]

positive_numbers = []
negative_numbers = []
result = 0
zero = False
for number in numbers:
    if number > 0:
        positive_numbers.append(number)
    elif number < 0:
        negative_numbers.append(number)
    else:
        zero = True

positive_numbers.sort()
negative_numbers.sort(reverse=True)

# 양수 처리
while len(positive_numbers) > 1:
    first = positive_numbers.pop()
    second = positive_numbers.pop()
    if first > 1 and second > 1:
        result += first * second
    else:
        result += first
        positive_numbers.append(second)

if positive_numbers:
    result += positive_numbers.pop()

# 음수 처리
while len(negative_numbers) > 1:
    first = negative_numbers.pop()
    second = negative_numbers.pop()
    result += first * second

# 남은 음수가 홀수 개인 경우 0이 있으면 0을 곱해서 없애고, 아니면 더합니다.
if negative_numbers and not zero:
    result += negative_numbers.pop()

print(result)