def solution(skill, skill_trees):
    answer = 0
    for s in skill_trees:
        stack = []
        #선행스킬이 있는지 없는지 판단
        can_skill = True
        for i in s:
            #만약에 skill_trees에 값을 하나하나 탐색하며 그 스킬이 skill에 포함된다면 추가하고
            if i in skill:
                stack.append(i)
                #stack의 인덱스와 skill의 인덱스가 다르면 스킬을 못찍는다고 판단하고 a= False, break
                if stack.index(i) != skill.index(i):
                    can_skill = False
                    break
        #a가 true이면 스킬찍을수있음
        if can_skill:
            answer += 1        
    return answer