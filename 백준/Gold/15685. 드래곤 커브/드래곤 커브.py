from collections import deque
n = int(input())
maps = [[0] * 101 for _ in range(101)]
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]
for i in range(n):
    y,x,d,g = map(int, input().split(" "))
    maps[x][y] = 1
    curve = [d]
    for j in range(g):
        for k in range(len(curve) -1 , -1, -1):
            curve.append((curve[k]+1) % 4)

    for j in range(len(curve)):
        x += dx[curve[j]]
        y += dy[curve[j]]
        if x < 0 or x >= 101 or y < 0 or y >= 101:
            continue
        maps[x][y] = 1
answer = 0
for i in range(100):
    for j in range(100):
        if maps[i][j] == 1 and maps[i + 1][j] == 1 and maps[i][j + 1] == 1 and maps[i + 1][j + 1] == 1:
            answer += 1
print(answer)