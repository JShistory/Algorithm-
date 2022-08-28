import sys
from collections import deque

n,k = map(int, sys.stdin.readline().split())
MAX = 100001

def bfs(n):
    q = deque()
    q.append(n)
    dist[n] = 1
    while q:
        x = q.popleft()
        if x == k:
            return dist[x]-1
        for nx in (x+1,x-1,x*2):
            if 0<=nx <MAX and dist[nx] == 0:
                if nx == x * 2:
                    dist[nx] = dist[x]
                    q.appendleft(nx)
                else:
                    dist[nx] = dist[x] +1
                    q.append(nx)

dist = [0 for _ in range(MAX)]
print(bfs(n))
