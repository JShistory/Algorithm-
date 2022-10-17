import math
def solution(str1, str2):
    answer = 0
    str1 = str1.upper()
    str2 = str2.upper()
    
    union = []
    inter = []
    str1_list = []
    str2_list = []
    str3_list = []
    
    for i in range(len(str1)-1):
        str1_list.append(str1[i:i+2])
    for i in range(len(str2)-1):
        str2_list.append(str2[i:i+2])
        str3_list.append(str2[i:i+2])
    
    for i in str1_list:
        if i.isalpha():
            if i in str3_list:
                inter.append(i)
                str3_list.remove(i)
        else:
            continue
            
    for i in str1_list:
        if i.isalpha():
            union.append(i)
            if i in str2_list:
                str2_list.remove(i)
        else:
            continue
    
    for i in str2_list:
        if i.isalpha():
            union.append(i)
        else:
            continue

    
    return math.floor((len(inter)/len(union)) * 65536) if union else 65536