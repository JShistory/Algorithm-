from collections import deque
n= int(input())
answer=0
bung = 0
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

#상하좌우
# dx = [-1,1,0,0]
# dy = [0,0,-1,1]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
def bfs(x,y):
    queue =deque()
    step = 1
    queue.append((x,y))
    graph[x][y] = 0
    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = dx[i]+x
            ny = dy[i]+y
            if nx <0 or nx >=n or ny<0 or ny>=n:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                queue.append((nx, ny))
                step +=1
    return step
country = []
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            country.append((bfs(i,j)))
country.sort()
print(len(country))
for i in country:
    print(i)



