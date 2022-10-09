n,m = map(int, input().split(" "))
data = []
for i in range(n):
    data.append(list(map(int, input().split(" "))))

moves = []
for i in range(m):
    tmp = list(map(int, input().split(" ")))
    moves.append([tmp[0]-1, tmp[1]])

clouds = [[n-1,0],[n-1,1],[n-2,0],[n-2,1]]

#←, ↖, ↑, ↗, →, ↘, ↓, ↙
dx = [0,-1,-1,-1,0,1,1,1]
dy = [-1,-1,0,1,1,1,0,-1]

for i in range(m):
    move = moves[i]
    next_clouds = []
    for cloud in clouds:
        x = cloud[0]
        y = cloud[1]
        d = move[0]
        s = move[1]
        nx = (n + x + dx[d] * s) % n
        ny = (n + y + dy[d] * s) % n
        next_clouds.append([nx, ny])

    visited = [[False]* n for _ in range(n)]
    for cloud in next_clouds:
        x = cloud[0]
        y = cloud[1]
        data[x][y] += 1
        visited[x][y] = True

    clouds =[]
    cx = [-1,-1,1,1]
    cy = [-1,1,-1,1]
    for cloud in next_clouds:
        x = cloud[0]
        y = cloud[1]
        count = 0
        for i in range(4):
            nx = x + cx[i]
            ny = y + cy[i]
            if 0<=nx<n and 0<=ny<n and data[nx][ny] >=1:
                count +=1
        data[x][y] += count

    for i in range(n):
        for j in range(n):
            if data[i][j] >=2 and visited[i][j] == False:
                data[i][j] -= 2
                clouds.append([i,j])

answer = 0
for i in range(n):
    answer += sum(data[i])

print(answer)