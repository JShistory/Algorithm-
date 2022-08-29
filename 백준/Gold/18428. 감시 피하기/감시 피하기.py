n = int(input())
data = []
dx = [-1,1,0,0]
dy = [0,0,-1,1]
#교실 맵을 복사할 temp
temp = [["X"] * n for _ in range(n)]

for i in range(n):
    data.append(list(input().split(" ")))

# print(data)
def check(x,y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        #while문을 이용해서 nx,ny를 계속 증가시켜줌. 직선방향으로
        while 0<=nx<n and 0<=ny<n and temp[nx][ny] !='W':
            #벽을 제외하고 학생을 만나면 감시가능.
            if temp[nx][ny] == "S":
                return True
            else:
                nx += dx[i]
                ny += dy[i]
    return False

def dfs(count):
    global answer
    if count == 3:
        teacher = True
        for i in range(n):
            for j in range(n):
                temp[i][j] = data[i][j]
        for i in range(n):
            for j in range(n):
                if temp[i][j] == "T":
                    if check(i,j):
                        #한번이라도 걸리면 NO임
                        teacher = False
        if teacher:
            answer = True
        return
    #벽을 3개 세운다.
    for i in range(n):
        for j in range(n):
            if data[i][j] == "X":
                data[i][j] = "W"
                count+=1
                dfs(count)
                data[i][j] = "X"
                count -=1
answer = False
dfs(0)
if answer:
    print("YES")
else:
    print("NO")

