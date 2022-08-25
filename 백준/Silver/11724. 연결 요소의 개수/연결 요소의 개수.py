from collections import deque
N,M = map(int, input().split(" "))
graph = [[] for _ in range(N+1)]
for i in range(M):
    a,b = map(int, input().split(" "))
    graph[a].append(b)
    graph[b].append(a)

def bfs(s):
    queue = deque()
    visited[s] = True
    queue.append(s)
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


answer = 0
visited = [False] * (N+1)

for i in range(1, N+1):
    if not visited[i]:
        if not graph[i]:
            answer +=1
            visited[i] = True
        else:
            bfs(i)
            answer+=1
print(answer)