from collections import deque
n,m = map(int, input().split(" "))
data =[]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
graph = [[0] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]
for i in range(n):
    data.append(list(map(int, input().split(" "))))
    for j in range(m):
        if data[i][j] == 2:
            start_x = i
            start_y = j

def bfs():
    q = deque()
    q.append((start_x,start_y))
    visited[start_x][start_y] = True
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0<=nx<n and 0<=ny<m and data[nx][ny] == 1 and visited[nx][ny] == False:
                visited[nx][ny] = True
                graph[nx][ny] = graph[x][y] + 1
                q.append((nx,ny))
bfs()
for i in range(n):
    for j in range(m):
        if visited[i][j] == False and data[i][j] != 0:
            graph[i][j] = -1

for i in graph:
    for j in i:
        print(j ,end=' ')
    print()