import math
from itertools import permutations
def check(user, ban):
    if len(user) != len(ban):
        return False
    else:
        for i in range(len(user)):
            if ban[i] == '*':
                continue
            elif ban[i] != user[i]:
                return False
    return True

def solution(user_id, banned_id):
    answer = []
    for perm in permutations(user_id,len(banned_id)):
        match = True
        for i in range(len(banned_id)):
            if not check(perm[i], banned_id[i]):
                match = False
        if match:
            if set(perm) not in answer:
                answer.append(set(perm))
    return len(answer)