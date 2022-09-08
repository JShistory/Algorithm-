n = int(input())
data = []
for _ in range(n):
    data.append(int(input()))
tip = 0
data.sort(reverse=True)

a= 1
for i in data:
    n = i-(a-1)
    if n < 0:
        n = 0
    tip += n
    a+=1
print(tip)