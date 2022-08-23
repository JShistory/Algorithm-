def solution(s):
    answer = []
    s = s[2:-2]
    s = s.split("},{")
    #크기로 오름차순 정렬
    s.sort(key = len)
    # print(s)
    for i in s:
        a = i.split(",")
        for j in a:
            if int(j) not in answer:
                answer.append(int(j))
    return answer