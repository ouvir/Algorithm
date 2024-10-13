N = int(input())
output = 0

for i in range(2, int(N/2+1)):
    output += i*(N//i -1) % 1000000

print(output % 1000000)