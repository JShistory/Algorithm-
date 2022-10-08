def solution(land):
    answer = 0
    for i in range(1,len(land)):
        for j in range(len(land[i])):
            # print(land[i-1][:j],land[i-1][j+1:])
            land[i][j] +=max(land[i-1][:j] + land[i-1][j+1:])
    return max(land[len(land)-1])
