def solution(id_list, report, k):
    user_id = {}
    report = list(set(report))
    answer = [0] * len(id_list)
    for i in id_list:
        user_id[i] = 0
    for i in report:
        user_id[i.split()[1]] +=1
    for i in report:
        if user_id[i.split()[1]] >=k:
            answer[id_list.index(i.split()[0])]+=1
            
    return answer