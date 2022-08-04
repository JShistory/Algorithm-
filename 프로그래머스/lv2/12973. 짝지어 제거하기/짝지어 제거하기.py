def solution(s):
    answer = []
    a = 0
    for i in s:
        if len(answer) == 0:
            answer.append(i)
        elif answer[-1] == i:
            answer.pop()
        else:
            answer.append(i)
    print(answer)
            
    if len(answer) == 0:
        a = 1
    else:
        a = 0
    return a