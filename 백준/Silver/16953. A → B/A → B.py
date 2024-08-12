A, B = map(int, input().split())
count = 0
while A < B:
    if str(B)[-1] == '1':
        B = int(str(B)[:-1])
    elif B % 2 == 1:
        break
    else:
        B //= 2
    count += 1

if A != B:
    print(-1)
else:
    print(count + 1)