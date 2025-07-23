import sys

N = int(sys.stdin.readline())
people_lst = list()
rank_lst = list()
for _ in range(N): # people 리스트에 자료를 받아 넣어주기
    x,y = map(int,sys.stdin.readline().split())
    people_lst.append((x,y))

for person in people_lst: # 1명씩 끌어와서 전체랑 비교-> 등수 정하기
    rank = 1
    for i in range(N):
        if person[0] < people_lst[i][0] and person[1] < people_lst[i][1]:
            rank += 1
    rank_lst.append(rank)

for j in rank_lst: #rank 출력
    print(j,end=" ")
print()