def solution(places):
    answer = []
    for p in places:
        covid = False
        data = []
        for n in p:
            data.append(list(n))

        for i in range(5):
            if covid:
                break
            for j in range(5):
                if covid:
                    break
                if data[i][j] == 'P':

                    if i + 1 < 5:
                        if data[i + 1][j] == 'P':
                            covid = True
                            break

                        if data[i + 1][j] == 'O':
                            if i+2 < 5:
                                if data[i + 2][j] == 'P':
                                    covid = True
                                    break
                    if j + 1 < 5:
                        if data[i][j + 1] == 'P':
                            covid = True
                            break

                        if data[i][j + 1] == 'O':
                            if j+2<5:
                                if data[i][j + 2] == 'P':
                                    covid = True
                                    break

                    if i + 1 < 5 and j + 1 < 5:
                        if data[i + 1][j + 1] == 'P' and (data[i][j + 1] == 'O' or data[i + 1][j] == 'O'):
                            covid = True
                            break

                    if i + 1 < 5 and j - 1 >= 0:
                        if data[i + 1][j - 1] == 'P' and (data[i + 1][j] == 'O' or data[i][j - 1] == 'O'):
                            covid = True
                            break
        if covid:
            answer.append(0)
        else:
            answer.append(1)
    return answer
