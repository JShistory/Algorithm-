import heapq
n = int(input())
discu = []
for i in range(n):
    discu.append(list(map(int, input().split(" "))))

discu.sort()
cnt = 1
heap = [0]
for s, e in discu:
    if s>=heap[0]:
        heapq.heappop(heap)
    else:
        cnt+=1
    heapq.heappush(heap,e)
print(cnt)