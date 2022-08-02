
def solution(d, budget):
    answer = 0
    count = 0
    d.sort()
    for i in d:
        if count < budget:
            count +=i
            if count > budget:
                break
            else:
                answer+=1
    return answer