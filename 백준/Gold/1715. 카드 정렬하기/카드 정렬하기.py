import heapq
n = int(input())
card = []
for i in range(n):
    num = int(input())
    heapq.heappush(card,num)


if len(card) == 1:
    print(0)
else:
    answer = 0
    while len(card) > 1:
        temp1 = heapq.heappop(card)
        temp2 = heapq.heappop(card)
        answer += (temp1 + temp2)
        heapq.heappush(card,temp1+temp2)
    print(answer)