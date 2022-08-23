from collections import deque
def solution(queue1, queue2):
    answer = -2
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    for i in range(len(queue1)*3):
        if sum1 == sum2:
            return i
        if sum1 > sum2:
            num = queue1.popleft()
            queue2.append(num)
            sum1 -=num
            sum2 +=num
        else:
            num = queue2.popleft()
            queue1.append(num)
            sum2 -=num
            sum1 +=num
    return -1
    