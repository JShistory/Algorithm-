def solution(s):
    answer = ''
    num = list(s.split(" "))
    max_num = -1e9
    min_num = 1e9
    for i in num:
        max_num = max(max_num,int(i))
        min_num = min(min_num,int(i))
    answer += str(min_num) + " "+ str(max_num)
    return answer