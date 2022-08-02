
def solution(nums):
    answer = 0
    temp = len(nums)//2
    a= list(set(nums))
    if len(a) > temp:
        return temp
    else:
        return len(a)