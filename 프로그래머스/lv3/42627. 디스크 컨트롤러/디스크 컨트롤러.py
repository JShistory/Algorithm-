import heapq
def solution(jobs):
    answer = 0
    start,i,now = -1,0,0
    heap = []
    while i < len(jobs):
        for j in jobs:
            #시작값과 현재값안에서 작업할 수 있는 디스크를 다 힙에 넣는다
            if start < j[0]<= now:
                heapq.heappush(heap, [j[1], j[0]])
        #만약에 작업할 값이 생긴다면 최소힙을 이용해 최소값을 하나 제거함
        if len(heap) > 0:
            cur = heapq.heappop(heap)
            start = now
            now += cur[0]
            answer += (now-cur[1])
            i += 1
        #작업할 것이 없다면 now를 1 증가시킴
        else:
            now +=1
    return int(answer/len(jobs))