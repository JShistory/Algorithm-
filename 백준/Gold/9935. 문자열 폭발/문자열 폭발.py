s = input()
boom = input()
data = []
# if boom not in s:
#     print(''.join(s))
boom_size = len(boom)
for i in s:
    data.append(i)
    if ''.join(data[-boom_size:]) == boom:
        del data[-boom_size:]
answer = ''.join(data)

if answer:
    print(answer)
else:
    print("FRULA")


