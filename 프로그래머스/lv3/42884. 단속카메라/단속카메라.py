def solution(routes):
    answer = 0
    routes = sorted(routes, key=lambda x:x[1])
    camera = -30001
    print(routes)
    for route in routes:
        print(camera)
        if camera < route[0]:
            answer +=1
            camera = route[1]
    return answer
    #진출 시점을 기준으로 오름차순 한 이유는 카메라를 최소로 설치해야 하기 때문임.
    #카메라를 진출 시점에 놓고 다음 자동차의 진입 시점이 더 크면 카메라를 한대 더 추가하고
    #카메라가 진출 시점 안에 있으면 카메라를 추가하지 않는다.