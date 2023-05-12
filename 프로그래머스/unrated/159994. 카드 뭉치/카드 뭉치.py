from collections import deque

def solution(cards1, cards2, goal):
    answer = ''
    deque_cards1 = deque(cards1)
    deque_cards2 = deque(cards2)
    deque_goal = deque(goal)
    print(deque_cards1)
    n = len(goal)
    for i in range(n):
        data = deque_goal.popleft()
        if data in deque_cards1:
            if data != deque_cards1.popleft():
                return "No"
        if data in deque_cards2:
            if data != deque_cards2.popleft():
                return "No"
            
        
    return "Yes"