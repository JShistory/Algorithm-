def solution(sticker):
    answer = 0
    if len(sticker) == 1:
        return sticker[-1]
    data1 = [0 for i in range(len(sticker))]
    data2 = [0 for i in range(len(sticker))]
    
    data1[0] = sticker[0]
    data1[1] = sticker[0]
    
    data2[0] = 0
    data2[1] = sticker[1]

    for i in range(2, len(sticker)-1):
        data1[i] = max(data1[i-2] + sticker[i], data1[i-1])
    data1_value = max(data1)
    
    for i in range(2, len(sticker)):
        data2[i] = max(data2[i-2]+sticker[i], data2[i-1])
    data2_value = max(data2)

    return max(data1_value, data2_value)