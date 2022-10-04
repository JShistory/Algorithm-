from itertools import combinations
from bisect import bisect_left
def solution(info, query):
    answer = []
    dict = {}
    for i in info:

        temp = i.split(" ")
        dict_key = temp[:-1]
        dict_val = temp[-1]

        for j in range(5):
            for combi in combinations(dict_key,j):
                s = "".join(combi)
                if s in dict:
                    dict[s] += [int(dict_val)]
                else:
                    dict[s] = [int(dict_val)]

    for i in dict:
        dict[i].sort()
    
    for i in query:
        i =i.replace("and","")
        i=i.replace("-","")
        i = i.split()
        
        dict_key = "".join(i[:-1])
        dict_val = int(i[-1])

        if dict_key in dict:

            score = dict[dict_key]
            if score:
                a = bisect_left(score,int(dict_val))
                answer.append(len(score)-a)
        else:
            answer.append(0)
    return answer