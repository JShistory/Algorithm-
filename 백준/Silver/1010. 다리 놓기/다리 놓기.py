import math
t = int(input())
for i in range(t):
    w,e = map(int, input().split(" "))
    b = math.factorial(e) // (math.factorial(w) * math.factorial(e-w))
    print(b)