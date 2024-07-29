def solution(key, lock):
    for _ in range(4):
        if check(key,lock):
            return True
        key = rotate(key)
        
    return False

def rotate(key):
    M = len(key[0])
    output = [ [0] * (M) for _ in range(M) ]
    
    for i in range(M):
        for j in range(M):
            output[j][M-1-i] = key[i][j]
            
    return output
    

def check(key, lock): # key를 움직이며, 확인
    N = len(lock[0])
    M = len(key[0])
    
    array = [[0] * (3 * N) for _ in range(3 * N)]

    for i in range(N):
        for j in range(N):
            array[i+N][j+N] = lock[i][j]

    for mx in range(2*N):
        for my in range(2*N):
            for i in range(M):
                for j in range(M):
                    array[mx + i][my + j] += key[i][j]

            if check_one(N, array):
                return True

            for i in range(M):
                for j in range(M):
                    array[mx + i][my + j] -= key[i][j]

    return False

def check_one(N, array):
    for i in range(N):
        for j in range(N):
            if array[i + N][j + N] != 1:
                return False
    return True