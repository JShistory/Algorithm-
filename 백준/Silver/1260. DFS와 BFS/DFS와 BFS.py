from collections import deque
def dfs(graph,v,visited):
    visited[v] = True
    print(v, end=' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)
def bfs(graph,start, visited):

    queue = deque([start])
    visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True




n,m,v = map(int, input().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    a,b=map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
for i in range(len(graph)):
    graph[i].sort()
# print(graph)
visited1 = [False] * (n+1)
visited2 = [False] * (n+1)
dfs(graph,v,visited1)
print()
bfs(graph,v,visited2)

