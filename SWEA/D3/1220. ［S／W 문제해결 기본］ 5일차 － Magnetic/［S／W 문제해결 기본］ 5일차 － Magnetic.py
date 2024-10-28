# 교착 상태만 파악하면 됨 > 그래프를 출력하는 것이 아님
# column 기준으로 보며, N극(1)이 S극(2) 보다 위에 있는 경우 교착 발생!
# 한 줄에 여러개의 교착 발생 가능
# 교착상태 세기 : 1을 만나면 flag = 1, 2를 만났을때, flag가 1이면, flag = 0 & count ++

T = 10
for test_case in range(1, T + 1):
    N = int(input())
    graph = [list(map(int, input().split())) for _ in range(N)]
    col_graph = list(map(list, zip(*graph)))
    
    count = 0
    for i in range(N):
        flag = False
        for j in range(N):
            if col_graph[i][j] == 1:
                flag = True
            elif col_graph[i][j] == 2 and flag:
                flag = False
                count += 1
    print(f"#{test_case} {count}")