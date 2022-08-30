from itertools import combinations
import sys
n, m = map(int, sys.stdin.readline().split())
data = []
chicken = []
home = []
for i in range(n):
    data.append(list(map(int, input().split(" "))))
    for j in range(n):
        if data[i][j] == 2:
            chicken.append((i,j))
        if data[i][j] == 1:
            home.append((i, j))

# 거리 계산 함수
def get_distance(r1, r2, c1, c2):
    return abs(r1 - r2) + abs(c1 - c2)

def get_sum(chic):
    answer = 0
    for r1, c1 in home:
        dis = 1e9
        for r2, c2 in chic:
            dis = min(dis, get_distance(r1, r2, c1, c2))
        answer += dis
    return answer

result = 1e9
for i in list(combinations(chicken,m)):
    result = min(result, get_sum(i))
print(result)

# import sys
#
# sys.setrecursionlimit(100000)
# n, m = map(int, sys.stdin.readline().split())
# data = []
# chicken = 0
# chic_list = []
# home = []
# for i in range(n):
#     data.append(list(map(int, input().split(" "))))
#     for j in range(n):
#         if data[i][j] == 2:
#             chicken += 1
#         if data[i][j] == 1:
#             home.append((i, j))
#
#
# # 거리 계산 함수
# def get_distance(r1, r2, c1, c2):
#     return abs(r1 - r2) + abs(c1 - c2)
#
#
# def dfs(chic):
#     global result
#     # 만약에 치킨집이 m개의 갯수에 만족했을 때
#     if chic == m:
#         # print(data)
#         answer = 0
#         chic_list = []
#         for i in range(n):
#             for j in range(n):
#                 if data[i][j] == 2:
#                     chic_list.append((i, j))
#
#         for r1, c1 in home:
#             dis = 999
#             for r2, c2 in chic_list:
#                 dis = min(dis, get_distance(r1, r2, c1, c2))
#
#             answer += dis
#         result = min(result, answer)
#         return
#     # 치킨집이 m개에 만족하지 못하면 치킨집을 계속 줄임
#     for i in range(n):
#         for j in range(n):
#             if data[i][j] == 2:
#                 data[i][j] = 0
#                 chic -= 1
#                 dfs(chic)
#                 data[i][j] = 2
#                 chic += 1
#
#
# result = 999
# dfs(chicken)
# print(result)