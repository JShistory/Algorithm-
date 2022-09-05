def solution(arr):
    answer = [-1]
    arr.remove(min(arr))
    return arr if arr else answer