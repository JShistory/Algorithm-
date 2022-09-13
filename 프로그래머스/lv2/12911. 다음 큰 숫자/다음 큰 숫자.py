def check_big_bin(n):
    cnt = bin(n).count('1')
    for i in range(n+1,1000001):
        if bin(i).count('1') == cnt:
            return i
    
def solution(n):
    answer = check_big_bin(n)
    return answer