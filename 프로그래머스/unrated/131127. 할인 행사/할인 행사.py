def solution(want, number, discount):
    answer = 0
    want_dict = {}
    sum_number = sum(number)
    #원하는 물품의 개수를 저장
    for i in range(len(want)):
        want_dict[want[i]] = number[i]
    
    for i in range(len(discount)-9):
        tmp = discount[i:i+10]
        #좀 더 빠르게 동작하기 위해서 set을 해줬는데 안해줘도 통과함.
        # tmp1 = list(set(tmp))
        for w in tmp:
            #for else문을 쓰기 위해서 케이스가 통과 못하는 경우만 체크
            #만약에 w가 want_dict안에 없으면 break
            if w not in want_dict:
                break
            #w가 있지만 개수가 달라도 break
            elif w in want_dict:
                if tmp.count(w) != want_dict[w]:
                    break
        #정상적으로 탈출했으면
        else:
            #print("break문 없이 정상적으로 탈출.")
            answer +=1
    return answer