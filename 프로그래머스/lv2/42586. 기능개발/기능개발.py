def solution(progresses, speeds):
    answer = []
    day = []
    day_sum = 0
    count = 0
    for i in range(len(progresses)):    
        for j in range(progresses[i],100,speeds[i]):
            count+=1
        day.append(count)
        count=0
    
    print(day)
    day_count = 1
    pro_f = day[0]
    for i in range(1,len(day)):
        
            
        if pro_f < day[i]:
            answer.append(day_count)
            pro_f = day[i]
            day_count = 1
        else:
            day_count +=1
        if i == len(day)-1:
            answer.append(day_count)
        
        
    
        
    return answer