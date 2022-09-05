import sys
import heapq
n = int(input())
heap = []
for i in range(n):
    m = int(sys.stdin.readline())
    if m == 0:
        try:
            print(heapq.heappop(heap)[1])
        except:
            print(0)
    else:
        heapq.heappush(heap,(abs(m),m))

