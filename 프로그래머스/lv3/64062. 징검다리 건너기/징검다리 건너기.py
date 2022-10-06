def solution(stones, k):
    left = 1
    right = 200000000
    while left <= right:
        mid = (left + right) // 2
        cnt = 0
        for t in stones:
            if t - mid <= 0:
                cnt += 1
            else:
                cnt = 0
            if cnt >= k:
                break
        print(left,right)
        if cnt >= k:
            right = mid - 1
        else:
            left = mid + 1
    return left
