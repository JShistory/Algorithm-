n,m = map(int, input().split(" "))


a = list(map(int, input().split(" ")))
b = list(map(int, input().split(" ")))

answer = a+b
answer.sort()

answer = ' '.join(map(str,answer))
print(answer)