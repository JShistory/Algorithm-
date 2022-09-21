import heapq
def solution(operations):
    answer = []
    min_heap = []
    max_heap = []
    for i in operations:
        #명령어 분리
        tmp = i.split(" ")
        a = int(tmp[1])
        #만약에 삽입 명령어라면
        if tmp[0] == 'I':
                #둘다 넣음?
                heapq.heappush(max_heap,(-a,a))
                heapq.heappush(min_heap,a)
        #만약에 삭제 명렁어라면
        elif not min_heap:
            continue
        elif tmp[0] == 'D':
            #최댓값 삭제 명령어라면
            if a==1:
                heapq.heappop(max_heap)
                min_heap.pop()
            #최솟값 삭제 명렁어라면
            elif a==-1:
                heapq.heappop(min_heap)
                max_heap.pop()


    #만약에 저장할 값이 없다면 0을 추가함
    if len(min_heap) > 0:
        return [max_heap[0][1],min_heap[0]]
    else:
        return [0,0]
    