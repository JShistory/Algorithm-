import sys
from collections import deque
k = int(sys.stdin.readline())
w,h = map(int, sys.stdin.readline().split())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(h)]
visited = [[[False] * (k+1) for _ in range(w)] for _ in range(h)]
# 상하좌우
dx = [-1,1,0,0]
dy = [0,0,-1,1]

jumpx = [-1,1,-2,-2,-1,1,2,2]
jumpy = [-2,-2,-1,1,2,2,-1,1]



def bfs(x,y):
    queue = deque()
    queue.append((x,y,0,0))
    visited[x][y][0] = True
    while queue:
        x,y,skill,cnt = queue.popleft()
        # 도착점이면 동작 횟수 리턴
        if x == h-1 and y == w-1:
            # print(graph)
            return cnt

        # 일반적인 이동
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < h and 0 <= ny < w:
                if visited[nx][ny][skill] == False:
                    if graph[nx][ny] == 0:
                        visited[nx][ny][skill] = True
                        # 특수 이동을 쓰지 않아서 skill은 증가시키지 않음
                        queue.append((nx, ny, skill, cnt + 1))
        #점프
        if skill < k:
            for i in range(8):
                nx = jumpx[i] + x
                ny = jumpy[i] + y
                if 0<=nx<h and 0<=ny<w:
                    #특수 이동을 하게 되면 현재 특수 이동 횟수 + 1번째에 방문하는 것임
                    if visited[nx][ny][skill+1] == False:
                        if graph[nx][ny] == 0:
                            visited[nx][ny][skill+1] = True
                            queue.append((nx,ny,skill+1,cnt+1))

    return -1


print(bfs(0,0))


