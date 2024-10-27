for c in range(1, 11):
	tc = int(input())
	li1 = [list(input()) for _ in range(100)] # 가로 계산용
	li2 = list(map(list, zip(*li1))) # 세로 계산용
	length = 0

play = True
for n in range(100, 1, -1):  # 찾을 회문 길이
	for i in range(100):
		if not play:
			break
		for j in range(100):
			if j + n < 100:
				row = li1[i][j:j+n]
				column = li2[i][j:j+n]
				if row == row[::-1] or column == column[::-1]:
					play=False
					length = n
					break
	if not play:
		break
print(f'#{tc} {length}')