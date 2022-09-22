def solution(x):
    answer = True
    num = 0
    for i in str(x):
        num+=int(i)
    return True if x % num == 0 else False