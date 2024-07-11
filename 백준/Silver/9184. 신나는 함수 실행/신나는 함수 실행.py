import sys

memo = [[[0 for i in range(101)] for j in range(101)] for k in range(101)]

def w(a,b,c):
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    if memo[a][b][c] != 0:
        return memo[a][b][c]
    
    if a > 20 or b > 20 or c > 20:
        memo[a][b][c] = w(20, 20, 20) 
        return memo[a][b][c]

    if a < b and b < c:
        memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
        return memo[a][b][c]

    else:
        memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
        return memo[a][b][c]

while True:
    a, b, c = map(int,sys.stdin.readline().split())
    if a == -1 and b == -1 and c == -1:
        break
    else:
        print("w(%d, %d, %d) = %d"%(a,b,c,w(a,b,c)))