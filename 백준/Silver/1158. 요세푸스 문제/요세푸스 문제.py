from collections import deque
n,k = map(int, input().split(" "))
list = deque()
answer = []
for i in range(1,n+1):
    list.append(i)

while len(list) != 0:
    list.rotate(-k)
    answer.append(list.pop())

print('<' + ', '.join(map(str, answer)) + '>')