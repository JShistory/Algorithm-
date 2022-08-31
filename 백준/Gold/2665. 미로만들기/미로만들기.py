from collections import deque
n = int(input())
data = []
dx = [-1,1,0,0]
dy = [0,0,-1,1]

#맵 생성
for i in range(n):
    data.append(list(map(int, input())))

def bfs(x,y):
    queue = deque()
    queue.append((x,y))
    visited = [[-1] * n for _ in range(n)]
    visited[x][y] = 0
    
    while queue:
        x,y = queue.popleft()
        if x == n-1 and y == n-1:
            # print(visited)
            return visited[x][y]
        for i in range(4):
            nx = dx[i]+x
            ny = dy[i]+y
            if 0<=nx<n and 0<=ny<n and visited[nx][ny] == -1:
                #흰방이면 흰방 먼저 탐색하고 visited의 값으로 초기화. 왜냐면 검은방에 개수를 묻는거기때문에
                if data[nx][ny] == 1:
                    queue.appendleft((nx,ny))
                    visited[nx][ny] = visited[x][y]
                else:
                    queue.append((nx,ny))
                    visited[nx][ny] = visited[x][y] +1
                    
print(bfs(0,0))