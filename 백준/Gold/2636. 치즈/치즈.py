import copy
from collections import deque
n,m = map(int, input().split(" "))
data = []
temp = [[0] * m for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
for i in range(n):
    data.append(list(map(int, input().split(" "))))


cnt = 0
def bfs(x,y,visited,temp):
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0<=nx<n and 0<=ny<m and visited[nx][ny] == False:
                if data[nx][ny] == 1:
                    visited[nx][ny] = True
                    temp[nx][ny] = 1
                if data[nx][ny] == 0:
                    visited[nx][ny] = True
                    q.append((nx,ny))

cnt = 0
while True:
    cnt += 1
    visited = [[False] * m for _ in range(n)]
    temp = [[0] * m for _ in range(n)]
    bfs(0,0,visited,temp)

    for i in range(n):
        for j in range(m):
            if temp[i][j] == 1:
                data[i][j] = 0
    temp1 = copy.deepcopy(data)
    ans = 0
    #모든 값이 0이면 break
    for i in range(n):
        ans += sum(temp1[i])
    if ans == 0:
        break
answer = 0
for i in range(n):
    answer += temp[i].count(1)
print(cnt)
print(answer)


