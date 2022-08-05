from itertools import permutations
def is_prime(n):
    if n < 2 :
        return False
    
    for i in range(2, n) :
        if n % i == 0 :
            return False 
    return True
                
            
def solution(numbers):
    answer = 0
    n_list = []
    number = []
    # n_list에 값
    for i in numbers:
        n_list.append(i)
    a = []
    for i in range(1,len(n_list)+1):
        a += list(permutations(n_list, i))
    number = [int(('').join(p)) for p in a]
      
    number = list(set(number))
    for i in number:
        if is_prime(i) == True:
            answer +=1
# pool = ['A', 'B', 'C']
# print(list(map(''.join, itertools.permutations(pool)))) # 3개의 원소로 수열 만들기
# print(list(map(''.join, itertools.permutations(pool, 2)))) # 2개의 원소로 수열 만들기
    return answer