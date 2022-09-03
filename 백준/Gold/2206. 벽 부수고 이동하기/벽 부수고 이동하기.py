from collections import deque
n,m = map(int, input().split(" "))
data = []
for _ in range(n):
    data.append(list(map(int, input())))
dx = [-1,1,0,0]
dy = [0,0,-1,1]

visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]

def bfs():
    q = deque()
    q.append((0,0,0))
    visited[0][0][0] = 1
    data[0][0] = 1
    while q:
        x,y,skill = q.popleft()
        if x == n-1 and y == m-1:
            return visited[x][y][skill]
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0<=nx<n and 0<=ny<m:
                if data[nx][ny] == 0 and visited[nx][ny][skill] == 0:
                    visited[nx][ny][skill] = visited[x][y][skill] + 1
                    q.append((nx,ny,skill))
                elif data[nx][ny] == 1 and skill == 0:
                    visited[nx][ny][1] = visited[x][y][0] + 1
                    q.append((nx,ny,1))
    return -1
print(bfs())




