from itertools import combinations
n = int(input())
data = []
for i in range(n):
    data.append(list(map(int, input().split(" "))))
combi = [combinations(data,i) for i in range(1, n+1)]
ans = 1e9
for com in combi:
    for i in com:
        S = 1
        B = 0
        for s,b in i:
            S *= s
            B += b
        ans = min(ans, abs(S-B))
print(ans)
