n,m = map(int , input().split(" "))
graph = []
temp = [[0] * m for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,-1,1]
for i in range(n):
    graph.append(list(map(int, input().split(" "))))
result = 0
#바이러스 퍼지게 하는 함수
def virus(x,y):
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if 0<=nx<n and 0<=ny<m:
            if temp[nx][ny] == 0:
                temp[nx][ny] = 2
                virus(nx,ny)
#안전한 영역을 구하는 함수
def get_score():
    score = 0
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 0:
                score +=1
    return score

def dfs(count):
    global result
    if count == 3:
        for i in range(n):
            for j in range(m):
                temp[i][j] = graph[i][j]

        for i in range(n):
            for j in range(m):
                if temp[i][j] == 2:
                    virus(i,j)
        #안전한 영역의 최댓값을 계속 넣어줌.
        result = max(result, get_score())
        return

    for i in range(n):

        for j in range(m):
  
            if graph[i][j]==0:
                graph[i][j] = 1
                # print(i,j)
                count+=1
                dfs(count)
                graph[i][j] = 0
                count-=1
dfs(0)
print(result)