import math


def timetoint(n):
    sum = 0
    h, m = map(int, n.split(":"))
    return h * 60 + m


def solution(fees, records):
    dt, df, ut, uf = fees
    answer = []
    fee_array = {}
    cars_parking = {}
    stay_minute = 0
    for car in records:
        # 만약 넣으려는 값이 안에 있으면 처리
        if car.split()[1] in cars_parking:
            stay_minute = timetoint(car.split()[0]) - cars_parking[car.split()[1]]
            fee_array[car.split()[1]] += stay_minute
            del cars_parking[car.split()[1]]
            continue

        cars_parking[car.split()[1]] = timetoint(car.split()[0])
        # 만약에 fee_array에 값이 있으면 패스하고 없으면 0으로 선 초기화
        if car.split()[1] in fee_array:
            pass
        else:
            fee_array[car.split()[1]] = 0
    # out이 없는 애들 처리
    for car in cars_parking.keys():
        fee_array[car] += timetoint('23:59') - cars_parking[car]

    list_fee_array = list(fee_array.items())
    list_fee_array.sort(key=lambda x: x[0])
    print(list_fee_array[0][1])
    for car in list_fee_array:
        if car[1] <= dt:
            answer.append(df)
        else:
            answer.append(df + math.ceil((car[1] - dt) / ut) * uf)
    return answer