from collections import deque


def solution(tickets):
    answer = []
    routes = dict()
    for (start, end) in tickets:
        if start in routes:
            routes[start].append(end)
        else:
            routes[start] = [end]
    for r in routes.keys():
        routes[r].sort(reverse=True)

    st = ["ICN"]
    path = []

    while st:
        top = st[-1]

        if top not in routes or len(routes[top]) == 0:
            path.append(st.pop())
        else:
            st.append(routes[top][-1])
            routes[top] = routes[top][:-1]

    answer = path[::-1]
    return answer

