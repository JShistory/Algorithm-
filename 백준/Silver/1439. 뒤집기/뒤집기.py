s = input()
c_1 = 0 # 전부 1로 바꾸는 경우
c_0 = 0# 전부 0으로 바꾸는 경우
if s[0] == '1':
    c_0 +=1
else:
    c_1 +=1
for i in range(len(s)-1):
    if s[i] != s[i+1]:
        if s[i+1] == '1':
            c_0 +=1
        else:
            c_1 +=1
print(min(c_0,c_1))


