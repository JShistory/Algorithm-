def solution(s):
    answer = True
    return answer if s.isdigit() and (len(s) == 4 or len(s) == 6) else False