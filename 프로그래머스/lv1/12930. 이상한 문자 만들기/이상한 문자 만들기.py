def solution(s):
    answer = ''
    a = s.split(" ")
    for i in a:
        for idx in range(len(i)):
            if idx % 2 == 0:
                answer +=i[idx].upper()
            else:
                answer +=i[idx].lower()
        answer +=' '
            
    return answer[0:-1]