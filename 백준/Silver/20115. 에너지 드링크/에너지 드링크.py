n = int(input())
drink = list(map(int, input().split(" ")))

drink.sort()
while len(drink) != 1:
    e1 = drink.pop()
    e2 = drink.pop()
    temp = 0
    if e1 >= e2:
        temp = e1 + e2/2
    else:
        temp = e2 + e1/2
    drink.append(temp)
print('%g'%drink[0])
