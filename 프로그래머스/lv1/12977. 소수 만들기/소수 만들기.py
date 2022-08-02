from itertools import combinations
def is_prime(nums):
    cnt = 1
    if nums==1 or nums == 2:
        return True
    else:
        for i in range(2,nums+1):
            if nums % i == 0:
                cnt+=1
        if cnt == 2:
            return True
        else:
            return False
            
            
    
def solution(nums):
    answer = 0
    nums_list = list(combinations(nums,3))
    
    for i in nums_list:
        a = is_prime(sum(i))
        
        if a == True:
            answer+=1
        else:
            pass
    return answer