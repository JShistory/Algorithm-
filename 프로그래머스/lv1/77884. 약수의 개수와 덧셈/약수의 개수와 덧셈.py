def solution(left, right):
    answer = 0
    count = 0
    for num in range(left,right+1):
        for i in range(1,num+1):
            if num % i == 0:
                count+=1
        if count % 2 == 0:
            answer +=num
            count = 0
        else:
            answer -=num
            count = 0
    return answer