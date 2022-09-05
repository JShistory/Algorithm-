import sys, heapq

input = sys.stdin.readline
heap = []
n = int(input())
for _ in range(n):
    arr = list(map(int, input().split()))
    if not heap:
        for num in arr:
            heapq.heappush(heap, num)
    else:
        for num in arr:
            if heap[0] < num:
                heapq.heappush(heap, num)
                heapq.heappop(heap)

print(heap[0])