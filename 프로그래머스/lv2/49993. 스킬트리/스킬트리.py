def solution(skill, skill_trees):
    answer = 0
    for s in skill_trees:
        stack = []
        a = True
        for i in s:
            if i in skill:
                stack.append(i)
                if stack.index(i) != skill.index(i):
                    a = False
                    break
        if a:
            answer += 1        
    return answer