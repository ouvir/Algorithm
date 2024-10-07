T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    dump = int(input())
    numbers = list(map(int, input().split()))
    
    for i in range(dump):
        numbers.sort()
        numbers[-1] -= 1
        numbers[0] += 1
    print(f"#{test_case} {max(numbers) - min(numbers)}")