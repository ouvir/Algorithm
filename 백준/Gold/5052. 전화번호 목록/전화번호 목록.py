import sys
input = sys.stdin.readline

tc = int(input())

def check(numbers):
    memo = set()
    for number in numbers:
        for i in range(len(number)):
            if number[:i+1] in memo:
                return "NO"
        memo.add(number)
    return "YES"

for _ in range(tc):
    N = int(input())
    numbers = [input().rstrip() for i in range(N)]
    numbers.sort(key=lambda x: len(x))
    print(check(numbers))