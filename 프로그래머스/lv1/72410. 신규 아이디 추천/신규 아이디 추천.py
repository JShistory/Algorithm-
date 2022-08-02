def solution(new_id):
    #1단계
    new_id = new_id.lower()
    #2단계
    answer =''
    for id in new_id:
        if id.isalnum() or id in ['-','_','.']:
            answer += id
    #3단계
    while '..' in answer:
        answer = answer.replace("..",".")
    #4단계
    answer = answer.strip(".")
    #5단계
    if answer == "":
        answer ='a'
    #6단계
    if len(answer)>=16:
        answer = answer[:15]
        if answer[-1] ==".":
            answer = answer[:-1]
    #7단계
    while len(answer) <3:
        answer +=answer[-1]
        
    return answer