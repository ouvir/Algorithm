def check(n, new_lock):  # 가운데에 0인 부분이 있는지 체크
    for i in range(n):
        for j in range(n):
            if new_lock[i + n][j + n] != 1: # 1이 아니면 자물쇠 못품
                return False
    return True

def rotate(m, key):
    new_arr = [[0] * m for _ in range(m)]
    for i in range(m):
        for j in range(m):
            new_arr[i][j] = key[m - j - 1][i]

    return new_arr

def solution(key, lock):
    n = len(lock)
    m = len(key)

    new_lock = [[0] * (n * 3) for _ in range(n * 3)] # 3배크기 배열 생성

    for i in range(n):  # 가운데에 기존 lock 추가
        for j in range(n):
            new_lock[i + n][j + n] = lock[i][j]

    for rot in range(4): # 회전 4번
        key = rotate(m, key)
        for x in range(2 * n):  # x축 이동
            for y in range(2 * n):  # y축 이동
                for i in range(m):  # 자물쇠에 열쇠 넣기
                    for j in range(m):
                        new_lock[x + i][y + j] += key[i][j]

                if check(n, new_lock):
                    return True
                
                for i in range(m):  # 자물쇠에 열쇠 빼기
                    for j in range(m):
                        new_lock[x + i][y + j] -= key[i][j]
    return False