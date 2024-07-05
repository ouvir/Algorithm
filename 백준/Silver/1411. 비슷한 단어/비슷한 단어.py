import sys

N = int(sys.stdin.readline())

word_list = []
for _ in range(N):
    word_list.append(sys.stdin.readline().rstrip())

count = 0

def compare(a,b):
    word_a = {'a':0,'b':0,'c':0,'d':0,'e':0,
        'f':0,'g':0,'h':0,'i':0,'j':0,
        'k':0,'l':0,'m':0,'n':0,'o':0,
        'p':0,'q':0,'r':0,'s':0,'t':0,
        'u':0,'v':0,'w':0,'x':0,'y':0, 'z':0}
    word_b = {'a':0,'b':0,'c':0,'d':0,'e':0,
        'f':0,'g':0,'h':0,'i':0,'j':0,
        'k':0,'l':0,'m':0,'n':0,'o':0,
        'p':0,'q':0,'r':0,'s':0,'t':0,
        'u':0,'v':0,'w':0,'x':0,'y':0, 'z':0}

    for i in range(len(a)):
        if word_a[a[i]] == 0:
            word_a[a[i]] = b[i]
        elif word_a[a[i]] != b[i]:
            return False
    for j in range(len(b)):
        if word_b[b[j]] == 0:
            word_b[b[j]] = a[j]
        elif word_b[b[j]] != a[j]:
            return False
        
    return True

for i in range(N-1):
    for j in range(i+1,N):
        if compare(word_list[i], word_list[j]):
            count += 1
print(count)