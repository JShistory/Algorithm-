def solution(A, B):
    answer = 0
    B.sort(reverse= True)
    A.sort(reverse= True)
    for n in A:
        #A = 1,3,5,7
        #B = 2,2,6,8
        
        #A = 7,5,3,1
        #B = 8,6,2,2
        if n < B[0]:
            answer += 1
            del B[0]
    return answer