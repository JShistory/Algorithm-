t = int(input())
data = []
for i in range(t):
    data.append(list(input()))

for i in data:
    temp = []
    for j in range(len(i)):
        if i[j] == ')' and temp and temp[-1] == '(':
            temp.pop()

        else:
            temp.append(i[j])

    if temp:
        print("NO")
    else:
        print("YES")


