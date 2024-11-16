import sys
input = sys.stdin.readline

N = int(input())
graph = list(map(int, input().split()))
output = [0] * (N+1)
stack = []

for i in range(len(graph) - 1, -1, -1):
    while stack:
        if graph[stack[-1]] >= graph[i]:
            break
        index = stack.pop()
        output[index + 1] = i + 1

    stack.append(i)

print(*output[1:])