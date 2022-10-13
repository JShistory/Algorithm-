import math
def solution(n, stations, w):
    answer = 0
    check = (w*2) + 1
    start = 1
    for i in stations:
        answer += max(math.ceil((i-w-start)/check),0)
        start = i + w + 1
    
    if n >= start:
        answer += math.ceil((n-start+1)/check)
    return answer