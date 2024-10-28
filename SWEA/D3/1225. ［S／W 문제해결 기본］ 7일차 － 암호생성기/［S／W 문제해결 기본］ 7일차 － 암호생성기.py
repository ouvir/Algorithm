# 한 사이클 -> 8번 반복 1~8까지 감소하는 사이클을 돌림
# list는 엄청난 오버헤드, deque 사용
from collections import deque

T = 10
for test_case in range(1, T + 1):
	tc = int(input())
	password = deque(list(map(int, input().split())))
	play = True
	while True:
		if not play:
			break
		for i in range(1, 6):
			target = password.popleft() - i
			if target <= 0:
				play = False
				password.append(0)
				break
			password.append(target)
	print(f"#{tc}", end=" ")
	print(*password)