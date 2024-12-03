import sys
A, B = map(int,sys.stdin.readline().split())
C = int(sys.stdin.readline())
if B+C > 59: 
    H,M = A+(B+C)//60, (B+C)%60
    if H>23:
        H -= 24
else: 
    H,M = A, B+C
print(H,M)