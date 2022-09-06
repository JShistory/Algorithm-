import sys


N = int(sys.stdin.readline())
a = list(map(int, sys.stdin.readline().split()))
stack = []
answer = []
for i in range(N):
    
    while stack:
        if stack[-1][1] > a[i]:
            answer.append(stack[-1][0] + 1)
            break
        else:
            stack.pop()
    if not stack: 
        answer.append(0)
    stack.append([i, a[i]])  
print(" ".join(map(str, answer)))
