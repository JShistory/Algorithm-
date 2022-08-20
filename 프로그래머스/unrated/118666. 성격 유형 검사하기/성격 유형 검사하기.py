def solution(survey, choices):
    answer = ''
    score = {1:3,2:2,3:1,4:0,5:1,6:2,7:3}
    mbti = {"R":0,"T":0, "C":0,"F":0, "J":0,"M":0, "A":0,"N":0}
    for m in range(len(survey)):
        data1 = survey[m][0]
        data2 = survey[m][1]
        if choices[m] > 4:
            mbti[data2] += score[choices[m]]
        elif choices[m] < 4:
            mbti[data1] += score[choices[m]]
    # print(mbti)
    answer += "R" if mbti["R"] >= mbti["T"] else "T"
    answer += "C" if mbti["C"] >= mbti["F"] else "F"
    answer += "J" if mbti["J"] >= mbti["M"] else "M"
    answer += "A" if mbti["A"] >= mbti["N"] else "N"
    
    return answer