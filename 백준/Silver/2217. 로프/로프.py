n = int(input())
rope = []
for _ in range(n):
    rope.append(int(input()))

rope.sort(reverse=True)

answer = []
for i in range(n):
    answer.append(rope[i]*(i+1))
print(max(answer))