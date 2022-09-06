n = int(input())
words = []
for _ in range(n):
    words.append(input())

dict = {}

for word in words:
    n = len(word) - 1
    for w in word:
        if w in dict:
            dict[w] += pow(10, n)
        else:
            dict[w] = pow(10, n)
        n-=1
answer=0
m = 9
dict = sorted(dict.values(), reverse=True)
for i in dict:
    answer+=(i*m)
    m-=1
print(answer)