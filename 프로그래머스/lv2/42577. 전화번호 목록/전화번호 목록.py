def solution(phone_book):
    phone = {}
    for i in phone_book:
        phone[i] = 0
    for number in phone_book:
        temp =''
        for num in number:
            #number가 한개씩 꺼내짐
            temp += num
            #print(temp)
            if temp in phone and temp != number:
                return False
            
    return True