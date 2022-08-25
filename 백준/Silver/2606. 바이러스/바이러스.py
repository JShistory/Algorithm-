from collections import deque
n = int(input())
k = int(input())
graph = [[] for _ in range(n+1)]
for i in range(k):
    a,b = map(int, input().split(" "))
    graph[a].append(b)
    graph[b].append(a)

def bfs(v):
    idx = 0
    queue = deque()
    queue.append(v)
    visited[v] = True
    while queue:
        n = queue.popleft()
        # print(n,end=' ')
        for i in graph[n]:
            if not visited[i]:
                idx +=1
                queue.append(i)
                visited[i] = True
    return idx
visited = [False] *(n+1)

print(bfs(1))