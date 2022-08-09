from collections import deque
def solution(prices):
    answer = []
    queue = deque(prices)
    sec = 0
    while queue:
        p = queue.popleft()
        for i in queue:
            sec+=1
            if p > i:
                break
            
        answer.append(sec)
        sec = 0
    return answer