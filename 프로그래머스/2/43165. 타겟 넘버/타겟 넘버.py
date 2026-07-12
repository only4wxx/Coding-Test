answer = 0
nums = []
target_sum = 0

def solution(numbers, target):
    global answer, nums, target_sum
    answer = 0
    nums = numbers
    target_sum = target
    
    get_possible_sum(0, 0)
    
    return answer

def get_possible_sum(current_sum, depth):
    global answer
    
    if depth == len(nums):
        if current_sum == target_sum:
            answer += 1
        return
    
    get_possible_sum(current_sum + nums[depth], depth+1)
    get_possible_sum(current_sum - nums[depth], depth+1)