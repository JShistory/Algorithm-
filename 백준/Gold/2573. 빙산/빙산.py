import sys
sys.setrecursionlimit(10000)
n,m = map(int, input().split(" "))
data = []
dx = [-1,1,0,0]
dy = [0,0,-1,1]
for i in range(n):
    data.append(list(map(int, input().split(" "))))
#주변에 물때문에 녹는 수



#주변에 바다가 몇개 있는지 체크하는 함수
def check_sea(x,y):
    for i in range(4):
        nx = dx[i]+x
        ny = dy[i]+y
        if 0<=nx<n and 0<=ny<m:
            if data[nx][ny] == 0:
                mountain[x][y] += 1

#남아있는 빙산을 체크하는 함수
def check_mountain(x,y,visited):
    visited[x][y] = True
    for i in range(4):
        nx = dx[i]+x
        ny = dy[i]+y
        if 0<=nx<n and 0<=ny<m:
            if visited[nx][ny] == False and data[nx][ny] != 0:
                check_mountain(nx,ny,visited)


#빙산이 녹는 년수를 저장
year = 0
while True:
    # 빙산 갯수
    result = 0
    #0인 갯수를 센다
    zero_count = 0
    #산과 인접해있는 바다를 저장
    mountain = [[0] * m for _ in range(n)]
    #방문처리
    visited = [[False] * m for _ in range(n)]
    #while문이 한번 반복될때마다 1년 추가
    year += 1

    #만약에 바다가 아니라 빙산이라면 check_sea를 통해서 인접해있는 바다가 몇개있는지 저장
    for i in range(n):
        for j in range(m):
            if data[i][j] != 0:
                check_sea(i,j)
    # print(mountain)

    #미리 저장되어있던 값에서 바다의 갯수를 뺌
    for i in range(n):
        for j in range(m):
            data[i][j] -=mountain[i][j]
            if data[i][j] < 0:
                data[i][j] = 0
    # print(data)
    # print(mountain)
    # break

    #만약에 바다가 아닌곳이 방문처리가 되어있지않으면 빙산이 몇개인지 확인
    for i in range(n):
        for j in range(m):
            if not visited[i][j] and data[i][j] != 0:
                check_mountain(i,j,visited)
                result +=1
    # print(visited)
    # print(data)
    for i in range(n):
        for j in range(m):
            if data[i][j] == 0:
                zero_count +=1

    #만약에 다 녹아버렸으면 0을 출력
    #빙산이 2개이상이면 년도 출력
    if zero_count == n*m:
        print(0)
        break
    if result > 1:
        print(year)
        break



