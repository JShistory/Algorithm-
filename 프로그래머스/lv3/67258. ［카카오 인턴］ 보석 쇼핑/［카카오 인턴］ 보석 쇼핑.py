def solution(gems):
    #현재 최단 구간 길이
    N = len(gems)+1
    answer = []
    check_len = len(set(gems))
    dic = {}
    
    l,r = 0,0
    while r < len(gems):
        if gems[r] in dic:
            dic[gems[r]] += 1
        else:
            dic[gems[r]] = 1
        r += 1
        
        if len(dic) == check_len:
            while l < r:
                if dic[gems[l]] > 1:
                    dic[gems[l]] -= 1
                    l += 1
                elif r-l < N:
                    N = r-l
                    answer = [l+1, r]
                    break
                else:
                    break
    return answer