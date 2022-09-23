from collections import deque
def solution(cacheSize, cities):
    answer = 0
    cache = deque()
    if cacheSize == 0:
        return 5*len(cities)
    for city in cities:
        #대소문자 구분 없이
        city = city.lower()
        #만약 캐시가 있으면
        if city in cache:
            answer += 1
            #LRU 알고리즘을 사용하기 위해 리스트를 이용합니다. 리스트의 맨 앞부분에 있는 요소를 제일 오래 참조가 안된 것(LRU)으로 보고 맨 뒤에 있는 요소를 제일 최근에 참조된 것(MRU)으로 생각합니다.
            cache.remove(city)
            cache.append(city)
        else:
        #만약 캐시가 없는데 캐시가 꽉차있으면 하나 삭제하고 추가
            if len(cache) == cacheSize:
                cache.popleft()
            cache.append(city)
            answer+=5

    return answer