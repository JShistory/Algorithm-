from collections import defaultdict
def solution(want, number, discount):
    answer = 0
    want_dict = defaultdict(list)
    sum_number = sum(number)
    
    for i in range(len(want)):
        want_dict[want[i]] = number[i]
    
    for i in range(len(discount)):
        if i + sum_number > len(discount):
            tmp = discount[i:len(discount)]
        else:
            tmp = discount[i:sum_number+i]
        
        if sum_number > len(tmp):
            break
        tmp1 = list(set(tmp))
        for j in tmp1:
            if j not in want_dict:
                break
            elif j in want_dict:
                if tmp.count(j) != want_dict[j]:
                    break
        else:
            answer +=1
                    
                
    return answer