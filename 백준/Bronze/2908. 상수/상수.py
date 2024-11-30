a, b = map(str,input().split())
a = list(a)
b = list(b)
a_s = int(a[2])*100+int(a[1])*10+int(a[0])
b_s = int(b[2])*100+int(b[1])*10+int(b[0])
if a_s > b_s:
    print(a_s)
else:
    print(b_s)