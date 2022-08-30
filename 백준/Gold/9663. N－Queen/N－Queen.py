n = int(input())
data = [0] * n
result = 0
def promising(x):
    for i in range(x):
        if data[x] == data[i] or abs(data[x] - data[i]) == x - i:
            return False
    return True

def dfs(x):
    global result
    if x == n:
        result +=1
    else:
        for i in range(n):
            data[x] = i
            if promising(x):
                dfs(x+1)
dfs(0)
print(result)