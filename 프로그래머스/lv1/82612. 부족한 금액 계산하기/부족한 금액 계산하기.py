def solution(price, money, count):
    answer = -1
    pay = 0
    for p in range(1,count+1):
        pay += (p*price)
        
    if pay <= money:
        return 0
    else:
        return pay-money