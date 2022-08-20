from collections import deque
answer = 0
m,n = map(int, (input().split(" ")))
graph = []
   # 상하좌우
dx = [-1,1,0,0]
dy = [0,0,-1,1]
queue = deque()
for i in range(n):
    graph.append(list(map(int, (input().split()))))
    for j in range(m):
        if graph[i][j] == 1:
            queue.append((i,j))
def bfs():
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i]+x
            ny = dy[i]+y
            if 0<= nx < n and 0<=ny<m and graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx,ny))
bfs()
tomato = True
#토마토가 안자란곳이 한곳이라도 있으면 False

for i in graph:
    for j in i:
        if j==0:
            print(-1)
            exit(0)
    answer = max(answer,max(i))
print(answer-1)



