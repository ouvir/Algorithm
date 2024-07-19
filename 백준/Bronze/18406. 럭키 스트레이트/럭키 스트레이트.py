import sys

input = sys.stdin.readline

S = input().rstrip()

mid = len(S) // 2

if sum(int(i) for i in S[:mid]) == sum(int(i) for i in S[mid:]):
    print("LUCKY") 
else:
    print("READY")