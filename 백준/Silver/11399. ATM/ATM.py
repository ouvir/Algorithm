import sys

N = int(sys.stdin.readline())

people = list(map(int, sys.stdin.readline().split()))

people.sort()

output = 0
time = 0

for person in people:
    time += person
    output += time
    
print(output)