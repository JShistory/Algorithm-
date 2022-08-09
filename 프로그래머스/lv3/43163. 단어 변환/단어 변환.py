from collections import deque
def solution(begin, target, words):
    if target not in words:  # 애초에 words리스트에 target값이 없다면 return 0
        return 0
    answer = 0
    
    queue = deque()
    queue.append([begin,0])
    
    while queue:
        
        begin,cnt = queue.popleft()
        if begin == target:
            return cnt
        for i in words:
            count = 0
            for j in range(len(begin)):
                if i[j] != begin[j]:
                    count+=1
            if count == 1:
                queue.append([i,cnt+1])
                    
                
                
    
    return 0