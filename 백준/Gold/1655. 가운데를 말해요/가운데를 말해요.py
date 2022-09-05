import sys
import heapq
n = int(input())
leftheap = []
rightheap = []
for i in range(n):
    m = int(sys.stdin.readline())
    if len(leftheap) == len(rightheap):
        heapq.heappush(leftheap, -m)
    else:
        heapq.heappush(rightheap, m)

    if rightheap and rightheap[0] < -leftheap[0]:
        leftvalue = heapq.heappop(leftheap)
        rightvalue = heapq.heappop(rightheap)

        heapq.heappush(leftheap, -rightvalue)
        heapq.heappush(rightheap, -leftvalue)
    print(-leftheap[0])

