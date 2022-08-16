from itertools import combinations
from collections import Counter
def solution(orders, course):
    answer = []
    cooking = []
    for i in course:
        cooking = []
        for j in orders:
            for x in combinations(j,i):
                cook = "".join(sorted(x))
                cooking.append(cook)
        
        sorted_cooking = Counter(cooking).most_common()
        answer += [menu for menu,cnt in sorted_cooking if cnt>1 and cnt == sorted_cooking[0][1]]
#         for menu, cnt in sorted_cooking:
#             if cnt > 1 and cnt == sorted_cooking[0][1]:
#                 answer.append(menu)
                
    return sorted(answer)