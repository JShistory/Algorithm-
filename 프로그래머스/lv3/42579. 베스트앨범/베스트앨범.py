def solution(genres, plays):
    total={} #장르별 총 재생횟수
    gen_dic={} #장르별 [재생횟수&고유번호]
    answer= []
    for i in range(len(genres)):
        ng = genres[i]
        np = plays[i]
        if ng in total:
            total[ng] += np
            gen_dic[ng].append((np,i))
        else:
            total[ng] = np
            gen_dic[ng] = [(np,i)]
    
    total = sorted(total.items(), key=lambda x : x[1], reverse = True)
    # print(total)
    # print(gen_dic)
    for i in total:
        playlist = gen_dic[i[0]]
        # print(playlist)
        playlist = sorted(playlist, key=lambda x : x[0], reverse = True)
        for j in range(len(playlist)):
            if j == 2:
                break
            answer.append(playlist[j][1])
    return answer