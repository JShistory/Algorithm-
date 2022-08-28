import sys
sys.setrecursionlimit(10000)
dx = [-1,1,0,0]
dy = [0,0,-1,1]
def dfs(x, y):

    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if 0 <= nx < n and 0 <= ny < m:
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                dfs(nx,ny)
t = int(input())
for i in range(t):
    m,n,k = map(int, input().split(" "))
    #맵 생성

    graph = [[0] * m for _ in range(n)]
    cnt = 0
    # print(graph)
    #배추 생성
    for _ in range(k):
        M,N = map(int, input().split(" "))
        graph[N][M] = 1
    for i in range(n):
        for j in range(m):
            if graph[i][j] > 0:
                dfs(i,j)
                cnt +=1
    print(cnt)





