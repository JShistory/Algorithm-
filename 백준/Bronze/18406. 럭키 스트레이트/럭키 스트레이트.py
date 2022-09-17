s = list(map(int, input()))
s1 = s[:len(s)//2]
s2 = s[len(s)//2:len(s)]

if sum(s1) == sum(s2):
    print("LUCKY")
else:
    print("READY")