from collections import deque
n = int(input())
#일반 사람의 색깔
data1 = []
#색맹의 색깔
data2 = [['.'] * n for _ in range(n)]
#좌표
dx = [-1,1,0,0]
dy = [0,0,-1,1]
#일반 사람의 방문처리
visited1 = [[False] * n for _ in range(n)]
#색맹의 방문처리
visited2 = [[False] * n for _ in range(n)]
#값 입력
for i in range(n):
    data1.append(list(input()))
    for j in range(n):
        #색맹이라서 R과 G를 임의의값 A로 바꿈
        if data1[i][j] == "R" or data1[i][j] == "G":
            data2[i][j] = "A"
        else:
            #B는 볼수  있으니 그대로 저장
            data2[i][j] = "B"
# print(data)
# print(color)
def bfs(graph,x,y,visited):
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0<=nx<n and 0<=ny<n:
                if graph[x][y] == graph[nx][ny] and visited[nx][ny] == False:
                    q.append((nx,ny))
                    visited[nx][ny] = True
    return True
#일반 사람의 색깔 답
answer1 = 0
#색맹의 색깔 답
answer2 = 0
for i in range(n):
    for j in range(n):
        #만약에 일반 사람의 방문처리가 False라면(방문하지 않았다면)
        if not visited1[i][j]:
            if bfs(data1, i, j, visited1):
                answer1 +=1
        #색맹 사람의 방문처리가 False라면(방문하지 않았다면)
        if not visited2[i][j]:
            if bfs(data2, i, j, visited2):
                answer2 += 1
print(answer1, answer2)
# def dfs(graph, start):