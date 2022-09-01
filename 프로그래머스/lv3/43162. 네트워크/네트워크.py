def solution(n, computers):
    visited = [False for _ in range(n)]
    answer = 0
    for i in range(n):
        if not visited[i]:
            dfs(n,computers,i,visited)
            answer+=1
    return answer
def dfs(n,computers,start, visited):
    visited[start] = True
    for i in range(n):
        if visited[i] == False and computers[start][i] == 1:
            dfs(n,computers,i,visited)
            
    