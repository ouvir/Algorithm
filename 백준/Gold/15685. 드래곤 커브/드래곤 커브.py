# 드래곤 커브 (시작점, 시작 방향, 세대)
# x,y,d,g 주어지면 이 좌표에서 드래곤 커브 그리기
# 모든 애들 그리고 graph 전체 순회하며, true가 4꼭짓점에 해당되면, output += 1
# 드래곤 커브 만드는 방법
# 특정 위치 이동하면서, true로 바꿔주면 됨 겹치기 상관 없으니까!
# 자기 자신 계속 기억 필요 for문에 list 사용해서 계속 반복하도록
# for -> list.append(이동 방향)
# 시간복잡도 -> O(N) * O(드래곤 커브 만들기) + O(graph순회하며 카운트)
# = O(N * g*2^g) + O(10000) = O(N* 10*2^10) = O(N) 충분
# 방향 값의 변화 (거꾸로부터 1씩 더해서 넣어주는 형태)
# g = 1 [0, 1]
# g = 2 [0, 1,/ 2, 1]
# g = 3 [0, 1, 2, 1,/ 2, 3, 2, 1]
# g = 4 [0, 1, 2, 1,/ 2, 3, 2, 1]


import sys

input = sys.stdin.readline

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

N = int(input())

dragon_curve = []

for _ in range(N):
    dragon_curve.append(list(map(int, input().split())))

graph = [[False] * 101 for _ in range(101)]


def check(i, j):
    if i >= 100 or i < 0 or j >= 100 or j < 0:
        return False
    if graph[i][j] and graph[i + 1][j] and graph[i][j + 1] and graph[i + 1][j + 1]:
        return True
    return False


for dragon in dragon_curve:
    x, y, d, g = dragon

    direction = [d]
    graph[x][y] = True

    for i in range(1, g + 1):
        tmp = []
        for curr_d in direction[::-1]:
            new_d = (curr_d + 1) % 4
            tmp.append(new_d)
        direction += tmp

    for cd in direction:
        x += dx[cd]
        y += dy[cd]
        graph[x][y] = True

output = 0
for i in range(101):
    for j in range(101):
        if check(i, j):
            output += 1
print(output)