import sys
sys.setrecursionlimit(10000)
from collections import deque
r,c = map(int, input().split(" "))
graph = []
#상하좌우
dx = [-1,1,0,0]
dy = [0,0,-1,1]
for i in range(r):
    graph.append(list(input()))
alphabet = set()
alphabet.add(graph[0][0])

def dfs(x,y,cnt):
    global answer
    answer = max(answer, cnt)
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if 0<=nx<r and 0<=ny<c:
            if graph[nx][ny] not in alphabet:
                #알파벳을 넣고
                alphabet.add(graph[nx][ny])
                dfs(nx,ny,cnt+1)
                #삭제하고
                alphabet.remove(graph[nx][ny])

answer = 0
dfs(0,0,1)
print(answer)
# def dfs(x,y):
#     q = deque()
#     check = []
#     q.append((x,y))
#     count = 0
#     check.append(graph[x][y])
#
#     while q:
#         x,y = q.popleft()
#
#         for i in range(4):
#             nx = dx[i] + x
#             ny = dy[i] + y
#             if 0<=nx<r and 0<=ny<c:
#                 if graph[nx][ny] not in check:
#                     check.append(graph[nx][ny])
#                     print(graph[nx][ny])
#                     graph[nx][ny] = 0
#                     count+=1
#                     q.append((nx,ny))
#     print(graph)
#     print(check)
#     return count
