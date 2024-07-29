import sys

input = sys.stdin.readline

tc = int(input())
        
for _ in range(tc):
    N, M = map(int,input().split())
   
    for _ in range(M):
        a, b = map(int,input().split())
    
    print(N-1)