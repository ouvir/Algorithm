#ord(A)-65 = 0
#ord(Z)-65 = 25
# 이를 토대로 list에 담기
# 담은 모든 수가 짝수인지 확인
# A부터 다 써서 만들기

alpha = [0] * (26)

name = input()

for n in name:
    alpha[ord(n)-65] += 1

tmp = []
count = 0
idx = 0
for i in range(26):
    if alpha[i] % 2 == 1:
        count += 1
        idx = i
    if count > 1:
        break
    for _ in range(alpha[i] // 2):
        tmp.append(str(chr(i + 65)))
        alpha[i] -= 1

if count > 1:
    print("I'm Sorry Hansoo")
else:
    if count == 1:
        tmp.append(chr(idx + 65))
        alpha[idx] -= 1
    for i in range(25, -1, -1):
        for _ in range(alpha[i]):
            tmp.append(chr(i + 65))
    print("".join(tmp))