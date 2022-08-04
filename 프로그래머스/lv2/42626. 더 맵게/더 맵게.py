import heapq
def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while scoville[0] < K:
        if len(scoville)>1:
            mix = heapq.heappop(scoville) + heapq.heappop(scoville)*2
            heapq.heappush(scoville,mix)
            answer += 1
        else:
            return -1
    return answer