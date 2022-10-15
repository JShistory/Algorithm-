from collections import deque
def solution(order):
    answer = 0
    data = deque([i for i in range(1,len(order)+1)])
    idx = 0
    belt = []
    
    while data:
        if order[idx] != data[0]:
            if belt and  order[idx] == belt[-1]: 
                idx += 1
                belt.pop()
            else:
                belt.append(data.popleft())
        else:
            idx +=1
            data.popleft()
    
    while belt:
        if belt[-1] == order[idx]:
            idx +=1
            belt.pop()
        else:
            break
        
    return idx