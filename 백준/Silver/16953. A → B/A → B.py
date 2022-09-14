from collections import deque
a,b = map(int, input().split(" "))
cnt = 0
q = deque()
q.append((a,1))
z = False
while q:
    n,t =q.popleft()

    if n > b:
        continue
    if n == b:
        z = True
        break
    q.append((int(str(n)+'1'),t+1))
    q.append((n*2,t+1))

if z:
    print(t)
else:
    print(-1)