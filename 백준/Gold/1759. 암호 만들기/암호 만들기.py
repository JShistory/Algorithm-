from itertools import combinations
L,C = map(int, input().split())

data = list(input().split())
data = list(set(data))
data.sort()
data = list(combinations(data,L))
for i in data:
    cnt_vowels = 0
    cnt_conson = 0
    for j in i:
        if j in 'a,e,i,o,u':
            cnt_vowels +=1
        else:
            cnt_conson +=1
    if cnt_conson >=2 and cnt_vowels >=1:
        print("".join(i))
# for s in combinations(data,L):
#     print("".join(s))