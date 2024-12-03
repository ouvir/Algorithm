X = int(input())
lst_n = 0
end_num = 0
while True:
    lst_n += 1
    end_num += lst_n
    if end_num >= X: break

start_num = end_num - lst_n + 1
point = X-start_num + 1
if lst_n%2 == 1:
    print("%d/%d"%(lst_n-point+1,point))
else:
    print("%d/%d"%(point,lst_n-point+1))
