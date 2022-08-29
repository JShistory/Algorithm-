from collections import deque
n,k = map(int, input().split(" "))
graph = []
data =[]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
for i in range(n):
    graph.append(list(map(int, input().split(" "))))
    for j in range(n):
        if graph[i][j] !=0:
            data.append((graph[i][j],0,i,j))
data.sort()
queue = deque(data)
t_s,t_x,t_y = map(int, input().split(" "))

while queue:
    virus, s, x, y= queue.popleft()
    if s == t_s:
        break
    for i in range(4):
        nx = dx[i]+x
        ny = dy[i]+y
        if 0<=nx<n and 0<=ny<n and graph[nx][ny] == 0:
            graph[nx][ny] = virus
            queue.append((virus,s+1,nx,ny))
# 동작구현
# queue = [(1,0,0,0),(2,0,0,2),(3,0,2,0)] 이렇게 있었음.
# 1 loop
# virus = 1 ,s = 0, x = 0, y = 0
# graph
# 1 1 2
# 1 0 0
# 3 0 0
# queue = [(2,0,0,2),(3,0,2,0),(1,1,0,1),(1,1,1,0)]
# 2 loop
# virus = 2, s = 0, x = 0 , y = 2
# graph
# 1 1 2
# 1 0 2
# 3 0 0
# queue = [(3,0,2,0),(1,1,0,1),(1,1,1,0),(2,1,1,2)]
# 3 loop
# virus = 3, s = 0, x = 2 , y = 0
# graph
# 1 1 2
# 1 0 2
# 3 3 0
# queue = [(1,1,0,1),(1,1,1,0),(2,1,1,2),(3,1,2,1)]
# 4 loop
# virus = 1, s = 1, x = 0 , y = 1
# graph
# 1 1 2
# 1 1 2
# 3 3 0
# queue = [(1,1,1,0),(2,1,1,2),(3,1,2,1),(1,2,1,1)]
# 5 loop
# virus = 2 s = 1, x = 1 , y = 2
# graph
# 1 1 2
# 1 1 2
# 3 3 0
# queue = [((3,1,2,1),(1,2,1,1),(2,2,2,2)]
# 6 loop
# if s == t_s 라는 내용이 참이돼서 break
print(graph[t_x-1][t_y-1])
