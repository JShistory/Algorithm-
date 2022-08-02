def solution(answers):
    k=0
    student1 = [1,2,3,4,5]
    s1 = 0
    student2 = [2,1,2,3,2,4,2,5]
    s2 = 0
    student3 = [3,3,1,1,2,2,4,4,5,5]
    s3 = 0
    c1=0
    c2=0
    c3=0
    for i in range(len(answers)):
        s1 = i%5
        s2 = i%8
        s3 = i%10
        
        if student1[s1] == answers[i]:
            c1 +=1
        if student2[s2] == answers[i]:
            c2 +=1
        if student3[s3] == answers[i]:
            c3 +=1
    k = max(c1,c2,c3)
    answer = []
    if k == c1:
        answer.append(1)
    if k == c2:
        answer.append(2)
    if k == c3:
        answer.append(3)
        
    
    return answer