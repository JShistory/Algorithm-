def solution(record):
    answer = []
    user_ip = {}
    for i in record:
        if i.split()[0] == "Enter":
            user_ip[i.split()[1]] = i.split()[2]
        elif i.split()[0] == "Change":
            user_ip[i.split()[1]] = i.split()[2]
    for i in record:
        if i.split()[0] == "Enter":
            answer.append(user_ip[i.split()[1]]+"님이 들어왔습니다.")
        if i.split()[0] == "Leave":
            answer.append(user_ip[i.split()[1]]+"님이 나갔습니다.")
    return answer