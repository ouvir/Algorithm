import sys
a = []
for _ in range(9):
    a.append(int(sys.stdin.readline()))
SUM = sum(a) 
a.sort()
for i in range(9):
    for j in range(i+1,9):
        if SUM - (a[i]+a[j]) == 100:
            for k in range(9):
                if k==i or k==j : continue
                print(a[k])
            sys.exit(0)