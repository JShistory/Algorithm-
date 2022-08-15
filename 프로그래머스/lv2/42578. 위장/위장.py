def solution(clothes):
    answer = 1
    cloth = {}
    for i in clothes:
        if i[1] in cloth:
            cloth[i[1]] +=[i[0]]
        else:
            cloth[i[1]] = [i[0]]
    
    # 경우의 수 구하기            
    for value in cloth.values():
        answer *= len(value) + 1
    
    # 아무것도 입지 않은 경우 하나 제외
    return answer-1