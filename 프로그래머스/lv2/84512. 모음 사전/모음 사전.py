def solution(word):
    answer = 0
    word_list = ['A','E','I','O','U']
    words = []
    for i in word_list:
        words.append(i)
        for j in word_list:
            words.append(i+j)
            for k in word_list:
                words.append(i+j+k)
                for x in word_list:
                    words.append(i+j+k+x)
                    for y in word_list:
                        words.append(i+j+k+x+y)
                    
                
            
        
        
    print(words)
    
    return words.index(word)+1