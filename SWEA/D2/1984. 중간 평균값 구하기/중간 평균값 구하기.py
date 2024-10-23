T = int(input())
def counting_sort(array):
    count = [0] * 10001
    output = []
    
    for n in array:
        count[n] += 1
    
    for i in range(len(count)):
        for _ in range(count[i]):
            output.append(i)
    return output

for test_case in range(1, T + 1):
    numbers = list(map(int, input().split()))
    sorted_numbers = counting_sort(numbers)
    output = sum(sorted_numbers[1:9]) / 8
    output = round(output, 0)
    print(f"#{test_case} {int(output)}")