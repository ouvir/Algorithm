N = str(input())
operations = N.split('-')

output = 0
output += sum(map(int, (operations[0].split('+'))))

for operation in operations[1:]:
    tmp = sum(map(int, (operation.split('+'))))
    output -= tmp
    
print(output)