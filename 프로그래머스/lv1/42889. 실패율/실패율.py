import operator
def solution(N, stages):
    answer = []
    clear_size= len(stages)
    dict = {}
    
    for stage in range(1,N+1):
        if clear_size !=0:
            
            dict[stage] = stages.count(stage)/clear_size
            clear_size-=stages.count(stage)
        else:
            dict[stage] = 0
    print(dict)
    return sorted(dict,key=lambda x: dict[x], reverse=True)