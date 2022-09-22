def solution(arr1, arr2):
    answer = [[0] * len(arr1[0]) for _ in range(len(arr1))]
    for i in range(len(arr1)):
        for j in range(len(arr1[0])):
            answer[i][j] = arr1[i][j] + arr2[i][j]
    
    return answer

# 1 2   +.  3 4    4 6
# 2 3       5 6    7 9