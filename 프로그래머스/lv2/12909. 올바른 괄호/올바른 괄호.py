def solution(s):
    answer = True
    stack = []
    for i in s:
        if '(' in stack and i == ')':
            stack.pop()
        else:
            stack.append(i)
    if stack:
        answer = False
    else:
        answer = True
    return answer
    