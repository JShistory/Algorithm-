from collections import deque
n,m = map(int, input().split(" "))
graph = [[] for _ in range(n+1)]
for i in range(m):
    a,b = map(int, input().split(" "))
    graph[b].append(a)

def bfs(start):
    q = deque()
    q.append(start)
    cnt = 1
    visited = [False for _ in range(n+1)]
    visited[start] = True
    while q:
        cur = q.popleft()
        for nx in graph[cur]:
            if not visited[nx]:
                visited[nx] = True
                cnt +=1
                q.append(nx)
    return cnt
answer = []
maxcnt = 0
for i in range(n+1):
    cnt = bfs(i)
    if cnt > maxcnt:
        maxcnt = cnt
    answer.append((i, cnt))
for i,cnt in answer:
    if cnt == maxcnt:
        print(i,end=" ")

