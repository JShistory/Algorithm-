def solution(s):
    answer = ''
    for s_split in s.split(" "):
        for i in range(len(s_split)):
            if i == 0:
                answer += s_split[i].upper()
            else:
                answer += s_split[i].lower()
        answer+=" "
    return answer[:-1]