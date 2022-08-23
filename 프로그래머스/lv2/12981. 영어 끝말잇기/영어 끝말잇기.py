from collections import deque
def solution(n, words):
    answer = []
    idx = 0
    count = 1
    queue = []
    queue.append(words[0])
    for i in range(1,len(words)):
        #queue에 마지막에 있는 -1의값이랑 words[i]의 마지막글자가 false고, words[i]가 queue에 있다면
        if not words[i].startswith(queue[-1][-1]) or words[i] in queue:
            answer.append((i%n)+1)
            answer.append((i//n)+1)
            break
        else:
            queue.append(words[i])
    #answer가 비어있으면 즉 끝말잇기가 끝까지 진행됐다면
    if not answer:
        answer.append(0)
        answer.append(0)
    return answer