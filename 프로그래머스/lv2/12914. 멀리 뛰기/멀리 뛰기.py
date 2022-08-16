from collections import deque
def solution(n):
    answer = 0
    if n<3:
        return n
    jump= [0] * (n+1)
    queue = deque()
    jump[1] = 1
    jump[2] = 2
    for i in range(3,n+1):
        jump[i] = jump[i-1] + jump[i-2]
        
    return jump[n]%1234567