n = int(input())
data = []
for i in range(n):
    data.append(list(map(int, input().split(" "))))

data = sorted(data, key=lambda x : (x[1],x[0]))
last = 0
cnt = 0
for s,e in data:
    if s >= last:
        cnt+=1
        last = e
print(cnt)