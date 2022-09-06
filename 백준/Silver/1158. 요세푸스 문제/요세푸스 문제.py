n,k = map(int, input().split(" "))
list = []
answer = []
for i in range(1,n+1):
    list.append(i)
idx = 0
for i in range(n):
    idx += k-1
    if idx >= len(list):
        idx %=len(list)
    answer.append(str(list.pop(idx)))
print("<"+", ".join(answer)+">")