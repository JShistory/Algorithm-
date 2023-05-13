def solution(s):
    answer = 0
    n = len(s)
    
    for i in range(n):
        
        if i != 0:
            s = s[1:] + s[:1]
        is_right_s = True
        stack = []
        for j in s:
            if len(stack) == 0:
                stack.append(j)
            else:
                if j == ")" and stack[-1] == "(":
                    stack.pop()
                elif j == "}" and stack[-1] == "{":
                    stack.pop()
                elif j == "]" and stack[-1] == "[":
                    stack.pop()
                else:
                    stack.append(j)
        if len(stack) == 0:
            answer += 1

        
        
    return answer