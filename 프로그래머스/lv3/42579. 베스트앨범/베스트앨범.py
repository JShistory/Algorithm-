def solution(genres, plays):
    answer = []
    g_dict = {}
    p_dict = {}
    
    for i in range(len(genres)):
        if genres[i] not in g_dict:
            g_dict[genres[i]] = plays[i]
            p_dict[genres[i]] = [(plays[i],i)]
        else:
            g_dict[genres[i]] +=plays[i]
            p_dict[genres[i]] += [(plays[i],i)]
    g_dict = sorted(g_dict.items(), key=lambda x : x[1], reverse = True)
    

    for i in g_dict:
        playlist = p_dict[i[0]]
        playlist = sorted(playlist, key=lambda x: x[0], reverse = True)
        for j in range(len(playlist)):
            if j==2:
                break
            answer.append(playlist[j][1])
        
    
    return answer