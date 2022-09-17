from collections import deque
n, k =map(int, input().split(" "))
data = []
virus = []
for i in range(n):
    data.append(list(map(int, input().split(" "))))
    for j in range(n):
        if data[i][j] != 0:
            virus.append((data[i][j],0,i,j))
virus.sort()
s,t_x,t_y = map(int, input().split(" "))

q = deque(virus)

dx = [-1,1,0,0]
dy = [0,0,-1,1]

while q:
    virus,time,x,y = q.popleft()
    if time == s:
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0<=nx<n and 0<=ny<n:
            if data[nx][ny] == 0:
                data[nx][ny] = virus
                q.append((virus, time+1, nx,ny))
print(data[t_x-1][t_y-1])