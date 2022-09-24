def solution(n, arr1, arr2):
    answer = []
    secret_map = [['.'] * n for _ in range(n)]
    for i in range(len(arr1)):
        tmp = bin(arr1[i] | arr2[i])
        tmp = tmp.lstrip('0b')
        tmp = tmp.zfill(n)
        tmp = tmp.replace('1','#')
        tmp = tmp.replace('0',' ')
        answer.append(tmp)
    return answer