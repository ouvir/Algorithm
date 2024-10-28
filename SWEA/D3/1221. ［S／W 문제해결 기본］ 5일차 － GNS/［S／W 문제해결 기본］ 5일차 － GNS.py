# 문자를 counting sort로 풀면 빠를듯함
stringNumber = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
mappingNumber = {"ZRO" : 0, "ONE" : 1, "TWO" :  2, "THR" : 3, "FOR" : 4, "FIV" : 5, "SIX" : 6, "SVN" : 7, "EGT" : 8 , "NIN" : 9}

def countingSort(array):
    output = []
    count = [0] * 10
    
    for n in array:
        count[mappingNumber[n]] += 1
        
    for i in range(10):
        for _ in range(count[i]):
            output.append(stringNumber[i])
    return output
T = int(input())
for test_case in range(1, T + 1):
    data = list(map(str, input().split()))
    N = data[1]
    numbers = list(map(str, input().split()))
    print(data[0])
    print(*countingSort(numbers))