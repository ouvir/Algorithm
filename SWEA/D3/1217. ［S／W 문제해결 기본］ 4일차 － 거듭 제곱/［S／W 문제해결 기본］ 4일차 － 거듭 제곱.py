T = 10
def square(number, cnt):
    if cnt == 0:
        return 1
    else:
        return number * square(number, cnt - 1)

for test_case in range(1, T + 1):
    tc = int(input())
    N, M = map(int, input().split())
    
    print(f"#{tc} {square(N, M)}")