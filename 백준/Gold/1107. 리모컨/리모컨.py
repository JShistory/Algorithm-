target = int(input())
m = int(input())
if m:
    error_button = list(map(int, input().split(" ")))
else:
    error_button = []
answer = abs(100-target)
for nums in range(1000001):
    nums = str(nums)
    for j in range(len(nums)):
        if int(nums[j]) in error_button:
            break
        elif j == len(nums)-1:
            answer = min(answer, abs(int(nums) - target) + len(nums))
print(answer)