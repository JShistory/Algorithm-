from collections import deque
n,m = map(int, input().split(" "))
data = []
dx = [-1,1,0,0]
dy = [0,0,-1,1]

for i in range(n):
    data.append(list(map(int, input().split(" "))))
h,w,s1,s2,f1,f2 = map(int, input().split(" "))
wall = []
visited = [[False] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if data[i][j] == 1:
            wall.append((i,j))


def check(i, j):
    for row, col in wall:
        if i <= row < i+h and j <=col < j+w:
            return False
    return True
def bfs():
    q = deque()
    q.append((s1-1,s2-1,0))

    while q:
        x,y,cnt = q.popleft()
        visited[x][y] = True
        if x == f1-1 and y == f2-1:
            return cnt
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0<= nx < n and 0<=ny<m and 0<= nx + h - 1 <n and 0<= ny + w - 1 < m:
                if visited[nx][ny] == False and check(nx,ny):
                    visited[nx][ny] = True
                    q.append((nx,ny,cnt+1))
    return -1
print(bfs())