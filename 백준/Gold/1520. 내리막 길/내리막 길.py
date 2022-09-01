from collections import deque
m,n = map(int, input().split(" "))
data = []
dp = [[-1] * n for _ in range(m)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]

for i in range(m):
    data.append(list(map(int, input().split(" "))))
def dfs(x,y):
    if x == m-1 and y == n-1:
        return 1
    if dp[x][y] != -1:
        return dp[x][y]
    dp[x][y] = 0
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if 0<=nx<m and 0<=ny<n:
            if data[x][y] > data[nx][ny]:
                dp[x][y] += dfs(nx, ny)
    # print(dp)
    return dp[x][y]
print(dfs(0,0))
#dp와 dfs를 활용한 문제
#m-1,n-1에 도달하면 return 1 을 해서 되돌아오게함


# def bfs(x,y):
#     q = deque()
#     q.append((x,y))
#     visited[x][y] = 1
#
#     while q:
#         x,y = q.popleft()
#         for i in range(4):
#             nx = dx[i] + x
#             ny = dy[i] + y
#             if 0<=nx<m and 0<=ny<n:
#                 if data[x][y] > data[nx][ny]:
#                     q.append((nx,ny))
#                     visited[nx][ny] = visited[x][y] + 1
#     print(visited)
#     return visited[m-1][n-1]
