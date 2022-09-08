from collections import deque
n,m,t = map(int, input().split(" "))
data = []
visited = [[0] * m for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
wall = []
for i in range(n):
    a = list(map(int, input().split(" ")))
    data.append(a)
    for j in range(m):
        if data[i][j] == 2:
            x1 = i
            y1 = j
            data[i][j] = 0
        if data[i][j] == 1:
            wall.append((i,j))

def bfs(x, y):
    gram = 10001
    q = deque()
    q.append((x,y))
    visited[x][y]= 1
    while q:
        x,y = q.popleft()
        if x == x1 and y == y1:
            gram = visited[x][y]-1 + n-1-x + m-1-y
        if x == n-1 and y == m-1:
            return min(visited[x][y]-1, gram)
        for i in range(4):
            nx = dx[i]+x
            ny = dy[i]+y
            if 0<=nx<n and 0<=ny<m and visited[nx][ny] == 0:
                if data[nx][ny] == 0:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx,ny))

    return gram
r = bfs(0,0)
if r > t:
    print("Fail")
else:
    print(r)