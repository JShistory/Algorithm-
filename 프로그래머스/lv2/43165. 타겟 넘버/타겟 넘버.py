from collections import deque

        
def solution(numbers, target):
    answer = 0
    queue = deque()
    queue.append([numbers[0],0])
    queue.append([-1*numbers[0],0])
    num = len(numbers)
    while queue:
        temp, idx = queue.pop()
        idx +=1
        if num > idx:
            queue.append([temp+numbers[idx],idx])
            queue.append([temp-numbers[idx],idx])
        else:
            if temp == target:
                answer +=1
                
    return answer