import math
def solution(n):
    answer = 0
    
    for i in range(1,int(math.sqrt(50000000000000 ))):
        if math.pow(i,2) == n:
            answer = math.pow(i+1,2)
    if answer==0:
        answer = -1
    return answer