import heapq


def solution(n, works):
    answer = 0
    data = [-i for i in works]
    heapq.heapify(data)
    if sum(works) <= n:
        return 0

    for i in range(n):
        x = heapq.heappop(data)
        x +=1
        heapq.heappush(data,x)

    for i in data:
        answer += (i ** 2)
    return answer