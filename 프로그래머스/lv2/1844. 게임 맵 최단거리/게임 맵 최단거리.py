from collections import deque
def solution(maps):
    answer = ''
    n = len(maps[0])
    m = len(maps)
    #  상 하 좌 우
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    def bfs(x,y):
        queue = deque()
        queue.append((x,y))
        while queue:
            x, y = queue.popleft()
            for i in range(4):
                nx, ny = x+dx[i], y+dy[i]
                if nx < 0 or ny < 0 or nx>=m or ny>=n:
                    continue
                if maps[nx][ny] == 0:
                    continue
                if maps[nx][ny] == 1:
                    maps[nx][ny] = maps[x][y] +1
                    queue.append((nx,ny))
        return maps[m-1][n-1]
    
    answer = bfs(0,0)
    
    return -1 if answer == 1 else answer 