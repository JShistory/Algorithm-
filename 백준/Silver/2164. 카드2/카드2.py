from collections import deque
n = int(input())
data = deque()
for i in range(1,n+1):
    data.append(i)
data.reverse()
while len(data) != 1:
    data.pop()
    data.appendleft(data.pop())
print(data[0])