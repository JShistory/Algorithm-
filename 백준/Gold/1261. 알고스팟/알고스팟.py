from collections import deque
n,m = map(int, input().split(" "))
graph = []
dx = [-1,1,0,0]
dy = [0,0,-1,1]
dist = [[-1] * n for _ in range(m)]
for i in range(m):
    graph.append(list(map(int, input())))
dist[0][0] = 0
def bfs(x,y):
    q = deque()
    q.append((x,y))

    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<m and 0<=ny<n:
                if dist[nx][ny] == -1:
                    if graph[nx][ny] == 0:
                        dist[nx][ny] = dist[x][y]
                        q.appendleft((nx,ny))
                    else:
                        dist[nx][ny] = dist[x][y] + 1
                        q.append((nx,ny))
    #print(dist)
    return dist[m-1][n-1]
print(bfs(0,0))