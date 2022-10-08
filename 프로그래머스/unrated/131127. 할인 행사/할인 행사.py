from collections import defaultdict
def solution(want, number, discount):
    answer = 0
    want_dict = defaultdict(list)
    sum_number = sum(number)
    #원하는 물품의 개수를 저장
    for i in range(len(want)):
        want_dict[want[i]] = number[i]
    
    for i in range(len(discount)):
        #만약에 인덱스가 넘어가면 i 부터 끝까지 나눔
        if i + sum_number > len(discount):
            tmp = discount[i:len(discount)]
        #만약에 인덱스 안에 포함되면 sum_number개만 딱 뽑는다
        else:
            tmp = discount[i:sum_number+i]
        #만약에 나눴는데 내가 사려는 물품보다 적으면 그냥 break시킴
        if sum_number > len(tmp):
            break
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