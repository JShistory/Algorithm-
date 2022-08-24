def solution(s):
    answer = True
    stack = []
    for i in s:
        if stack and i == ')' and stack[-1] == '(':
            stack.pop()
        else:
            stack.append(i)
    print(stack)
    if stack:
        return False
    else:
        return True
