def solution(a, b):
    year = {1:"FRI",2:"SAT",3:"SUN",4:"MON",5:"TUE",6:"WED",0:"THU"}
    month = {1:31,2:60,3:91,4:121,5:152,6:182,7:213,8:244,9:274,10:305,11:335,12:366}
    answer = ''
    day = 0
    if a == 1:
        day =year[b % 7]
    else:
        day = year[(month[a-1] + b) % 7]
        
    return day