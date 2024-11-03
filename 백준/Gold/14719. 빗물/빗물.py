# 현재 지점 기준 계산
# 현재 지점의 고인 물의 총량 = min(왼쪽 가장 큰 값, 오른쪽 가장 큰 값) - 현재 지점 세로 길이
# 시간복잡도 -> O(W) 탐색 * W = O(W^2) = 250000 (25만)
import sys
input = sys.stdin.readline

H, W = map(int, input().split())
graph = list(map(int, input().split()))

output = 0
for i in range(1, W-1):
    tmp = min(max(graph[:i]), max(graph[i+1:])) - graph[i]
    if tmp > 0:
        output += tmp
print(output)