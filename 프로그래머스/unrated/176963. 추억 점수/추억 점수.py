def solution(name, yearning, photo):
    answer = []
    photo_score = {};
    for i in range(len(name)):
        photo_score[name[i]] = yearning[i]
    print(photo_score)
    
    for i in range(len(photo)):
        num = 0;    
        for j in photo[i]:
            if j in photo_score:
                num += photo_score[j]
        answer.append(num)
    return answer