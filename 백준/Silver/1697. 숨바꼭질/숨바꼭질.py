from collections import deque
n,k = map(int, input().split(" "))

def bfs(n):
    q = deque()
    q.append(n)
    while q:
        v = q.popleft()
        if v == k:
            return dist[v]
        for nx in (v+1, v-1, v*2):
            if 0 <= nx <= 100000 and not dist[nx]:
                dist[nx] = dist[v] + 1
                q.append(nx)
dist = [0] * 100001
print(bfs(n))
# n이 5이고 타겟이 17일때 동작하는순서
# x = 5 dist[5]
# dist[4] = 1
# dist[6] = 1
# dist[10] = 1
#
# x = 10 dist[10]
# dist[11] = dist[10] + 1= 2
# dist[9] = dist[10] + 1 = 2
# dist[20] = dist[10] + 1 = 2
#
# x = 9 dist[9]
# dist[8] = dist[9] + 1 = 3
# dist[10] = dist[9] + 1 =3
# dist[18]= dist[9] + 1 =3
#
# x = 18 dist[18]
#
# dist[19] = dist[18] + 1
# dist[17] = dist[18] + 1
# dist[36] = dist[18] + 1


