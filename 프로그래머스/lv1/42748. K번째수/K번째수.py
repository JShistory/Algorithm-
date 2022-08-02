def solution(array, commands):
    answer = []
    correc = []
    for i in range(len(commands)):
        
        answer = array[commands[i][0]-1:commands[i][1]]
        answer.sort()
        correc.append(answer[commands[i][2]-1])
    return correc