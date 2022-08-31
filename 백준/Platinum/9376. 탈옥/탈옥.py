from collections import deque
t = int(input())

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(x,y):
    visited = [[-1] * (w+2) for _ in range(h+2)]
    q = deque()
    q.append((x,y))
    visited[x][y] = 0
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0<=nx<h+2 and 0<=ny<w+2 and visited[nx][ny] == -1:
                if data[nx][ny] == '$' or data[nx][ny] == '.':
                    visited[nx][ny] = visited[x][y]
                    q.appendleft((nx,ny))
                elif data[nx][ny] == '#':
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx,ny))
    return visited


for _ in range(t):
    #t번 반복
    h,w = map(int, input().split(" "))
    data = [list('.' * (w+2))]
    for i in range(h):
        data.append(list('.'+input().strip()+'.'))
    data.append(list('.'*(w+2)))
    # print(data)

    people = []
    for i in range(h+2):
        for j in range(w+2):
            if data[i][j] == '$':
                people.append((i,j))
    p1 = bfs(people[0][0],people[0][1])
    p2 = bfs(people[1][0],people[1][1])
    m = bfs(0,0)
    # print(p1)
    # print(p2)
    # print(m)
    answer = 1e9

    for i in range(h+2):
        for j in range(w+2):
            if p1[i][j] != -1 and p2[i][j] != -1 and m[i][j] != -1:
                result = p1[i][j] + p2[i][j] + m[i][j]
                if data[i][j] == '*':
                    continue
                if data[i][j] == '#':
                    result -=2
                answer = min(answer, result)
    print(answer)


