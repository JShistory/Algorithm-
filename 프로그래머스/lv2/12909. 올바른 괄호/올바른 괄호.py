def solution(s):
    answer = True
    stack = []
    for i in s:
        
        if '(' in stack and i == ')':
            stack.pop()
        else:
            stack.append(i)
    
    print(stack)
    if stack:
        return False
    else:
        return True
    