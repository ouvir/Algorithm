T = int(input())

for _ in range(T):
    count = [0] * 26

    W = input()
    K = int(input())

    max_output = 0
    min_output = len(W)

    for i in range(len(W)):  # 문자 수 세기
        count[ord(W[i]) - 97] += 1

    index_dict = {}
    # 문자 수가 K개 이상인 애들의 위치 값 넣어두기
    for i in range(len(W)):
        if count[ord(W[i]) - 97] < K:
            continue
        index_dict[W[i]] = index_dict.get(W[i], []) + [i]

    for v in index_dict.values():
        for i in range(len(v) - K + 1):
            max_output = max(max_output, v[i + K - 1] - v[i] + 1)
            min_output = min(min_output, v[i + K - 1] - v[i] + 1)

    if max_output == 0 and min_output == len(W):
        print(-1)
    else:
        print(min_output, max_output)
