def solution(gems):
    #현재 최단 구간 길이
    N = len(gems)+1
    answer = []
    check_len = len(set(gems))
    dic = {}
    l,r = 0,0
    #right포인터를 len(gems)-1만큼 증가시켜서 보석을 담고
    while r < len(gems):
        if gems[r] in dic:
            dic[gems[r]] += 1
        else:
            dic[gems[r]] = 1
        r+=1
        #만약 보석의 개수가 충족됐을 때
        if len(dic) == check_len:
            #left포인터로 보석의 크기가 1이상인 것만 하나씩 줄여간다(최소 보석을 원하기떄문에)
            while l < r :
                if dic[gems[l]] > 1:
                    dic[gems[l]] -= 1
                    l += 1
                elif r-l < N:
                    N = r-l
                    answer = [l+1,r]
                else:
                    break

    return answer