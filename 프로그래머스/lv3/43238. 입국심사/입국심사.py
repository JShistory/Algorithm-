def solution(n, times):
    answer = 0
    start,end = 1, max(times)*n
    while start <= end:
        mid = (start+end) // 2
        p = 0
        for time in times:
            p += (mid//time)
            if p >= n:
                break
        if p>=n:
            end = mid-1
            answer = mid
        else:
            start = mid+1   
    return answer