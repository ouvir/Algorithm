import sys

N = int(sys.stdin.readline())

distance = list(map(int, sys.stdin.readline().split()))
price_per_liter = list(map(int, sys.stdin.readline().split()))
min_price = price_per_liter[0]
count = 0

for i in range(len(price_per_liter)-1):
    min_price = min(min_price, price_per_liter[i])
    count += min_price * distance[i]

print(count)
