from collections import deque
n,l,r = map(int, input().split(" "))
data = []
dx = [-1,1,0,0]
dy = [0,0,-1,1]

for i in range(n):
    data.append(list(map(int, input().split(" "))))

def bfs(x,y,index):
    united = []
    united.append((x,y))

    q = deque()
    q.append((x,y))
    union[x][y] = index # 현재 연합의 번호 할당
    summary = data[x][y] #현재 연합의 전체 인구 수
    count = 1 #현재 연합 국가의 수
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<n and union[nx][ny] == -1:
                if l <= abs(data[nx][ny] - data[x][y]) <= r:
                    q.append((nx,ny))
                    union[nx][ny] = index
                    summary += data[nx][ny]
                    united.append((nx,ny))
                    count+=1
    for i,j in united:
        data[i][j] = summary // count
    return count

total_count = 0
while True:
    union = [[-1] * n for _ in range(n)]
    index = 0
    for i in range(n):
        for j in range(n):
            if union[i][j] == -1:
                bfs(i,j,index)
                index +=1
    if index == n*n:
        break
    total_count +=1
print(total_count)

