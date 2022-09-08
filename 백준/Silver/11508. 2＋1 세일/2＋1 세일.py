n = int(input())
data = []
for _ in range(n):
    data.append(int(input()))
data.sort()
price = 0
while len(data) >=3:
    p1= data[-1]
    p2 = data[-2]
    p3 = data[-3]
    price+=(p1 + p2)
    data.remove(p1)
    data.remove(p2)
    data.remove(p3)

for i in data:
    price +=i
print(price)