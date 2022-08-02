def solution(lottos, win_nums):
    answer = []
    answer1= []
    for i in range(6):
        
        if lottos[i] in win_nums:
            answer1.append(lottos[i])
            
        elif lottos[i] == 0:
            answer1.append(0)        
    count = 0
    dict = {0:6,1:6,2:5,3:4,4:3,5:2,6:1}
    answer.append(dict[len(answer1)])
    while 0 in answer1:
        answer1.remove(0)
    answer.append(dict[len(answer1)])

    
    return answer