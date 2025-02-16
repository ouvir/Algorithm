import sys
S = sys.stdin.readline().rstrip()
st = []
operator_dict = {'+':1,'-':1,'*':2,'/':2}
for i in S:
    if i.isalpha(): # i == A,B,C...
        print(i,end='')
    elif i in operator_dict.keys(): # i == +, -, *, /
        while st and st[-1] != '(' and operator_dict[st[-1]] >= operator_dict[i]:
            print(st.pop(),end='')
        st.append(i)            
    else: # i == (, )
        st.append(i)
        if st[-1]== ')':
            st.pop()
            while st[-1] != '(':
                print(st.pop(),end='')
            st.pop()
while len(st) != 0:
    print(st.pop(),end='')
