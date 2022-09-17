from itertools import combinations
n,m = map(int, input().split(" "))
data = []
chicken = []
home = []
for i in range(n):
    data.append(list(map(int, input().split(" "))))
    for j in range(n):
        if data[i][j] == 1:
            home.append((i,j))
        if data[i][j] == 2:
            chicken.append((i,j))

def get_distance(r1,r2,c1,c2):
    return abs(r1-r2) + abs(c1-c2)

def simulate(chic):
    ans = 0
    for r1,c1 in home:
        min_dis = 1e9
        for r2,c2 in chic:
            min_dis = min(min_dis, get_distance(r1,r2,c1,c2))
        ans += min_dis
    return ans
result = 1e9
for i in combinations(chicken,m):
    result = min(result,simulate(i))
print(result)