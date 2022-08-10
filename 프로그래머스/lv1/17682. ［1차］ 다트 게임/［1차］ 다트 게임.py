def solution(dartResult):
    dart = []
    a = 0
    count = 0
    for i in dartResult:
        if count == 1 and i == '0':
            a = 10
        elif ord(i) >= 48 and ord(i) <=57:
            a = i
            count = 1

        elif i == 'S':
            dart.append(int(a)**1)
            count =0
        
        elif i == 'D':
            dart.append(int(a)**2)
            count =0
            
        elif i == 'T':
            dart.append(int(a)**3)
            count =0
        elif i == '*':
            if len(dart) < 2:
                dart[-1] = dart[-1] * 2
                count =0
            else:
                dart[-1] = dart[-1] * 2
                dart[-2] = dart[-2] * 2
                count =0
        
        elif i == '#':
            dart[-1] = dart[-1] * -1
            count =0

    return sum(dart)