T = int(input())

def check_row_line(graph):
    for i in range(9):
        numbers = set()
        for j in range(9):
        	numbers.add(graph[i][j])
        if len(numbers) != 9:
        	return False
    return True
    
def check_column_line(graph):
    for j in range(9):
        numbers = set()
        for i in range(9):
        	numbers.add(graph[i][j])
        if len(numbers) != 9:
        	return False
    return True
    
def check_3x3(graph):
    for k in range(0, 7, 3):
        numbers = set()
        for i in range(k, k+3):
            for j in range(k, k+3):
                numbers.add(graph[i][j])
        if len(numbers) != 9:
        	return False
    return True

for test_case in range(1, T + 1):
    graph = [list(map(int, input().split())) for _ in range(9)]
    output = 0
    if check_row_line(graph) and check_column_line(graph) and check_3x3(graph):
        output = 1
    print(f"#{test_case} {output}")