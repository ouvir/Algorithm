import sys
input = sys.stdin.readline
N, K = map(int, input().split())
number = list(map(int, input().rstrip()))

stack = []
for n in number:
    while K > 0 and stack and stack[-1] < n:
        stack.pop()
        K -= 1
    stack.append(n)

while K > 0:
    stack.pop()
    K -= 1

print("".join([str(i) for i in stack]))