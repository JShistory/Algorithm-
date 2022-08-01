def solution(phone_book):
    answer = True
    hash_map = {}
    for i in phone_book:
        hash_map[i] = 1

    for i in phone_book:
        jubdoo = ""
        for number in i:
            jubdoo += number
            if jubdoo in hash_map and jubdoo != i:
                answer = False
    return answer