from collections import deque
n,m = map(int, input().split(" "))
data = []
temp = [[0] * m for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
for i in range(n):
    data.append(list(map(int, input().split(" "))))



def bfs(x,y,visited,temp):
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            #만약에 치즈(1)이라면 temp에 같은 좌표에 1을 저장
            #만약에 0이면 q에 삽입
            #방문처리를 해줌으로써 중복을 줄여줌
            if 0<=nx<n and 0<=ny<m and visited[nx][ny] == False:
                if data[nx][ny] == 1:
                    visited[nx][ny] = True
                    temp[nx][ny] = 1
                if data[nx][ny] == 0:
                    visited[nx][ny] = True
                    q.append((nx,ny))

cnt = 0
while True:
    cnt += 1
    #방문처리 visited
    #temp는 치즈 기억하는 배열을
    #계속 초기화함
    visited = [[False] * m for _ in range(n)]
    temp = [[0] * m for _ in range(n)]
    bfs(0,0,visited,temp)

    for i in range(n):
        for j in range(m):
            #만약에 temp에 치즈값이 기억됐다면 그 부분을 data에서 0으로 바꿔줌
            if temp[i][j] == 1:
                data[i][j] = 0
    #모든 치즈가 사라지는걸 판별하는 ans
    ans = 0
    for i in range(n):
        ans += sum(data[i])
    # temp1에 1이 하나도 없다면. 즉 모든 합이 0이면 break
    if ans == 0:
        break
answer = 0
for i in range(n):
    answer += temp[i].count(1)
print(cnt)
print(answer)


