def solution(n):
    answer = 0
    data = []
    while n != 0:
            data.append(n%3)
            n = n//3
    data_size = len(data)-1
    
    for i in data:
        answer += i*(3**data_size)
        data_size -=1
    
    return answer