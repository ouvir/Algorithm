import sys

# 배열을 받아 이를 저장한 뒤, 이를 열 순으로 출력
# 2차원 배열 저장시 행과 열을 저장 후, 출력시 역으로 출력되게 설정하기

# 기본세팅 2차원 배열
a = [[] for i in range(5)]

for i in range(5):
    row = list(sys.stdin.readline().rstrip())
    for j,item in enumerate(row):
        a[i].append(item)


# 출력 시, 요소가 비어있으면 pass
for i in range(15):
    for j in range(5):
        if len(a[j]) > i:
            print(a[j][i],end="")    