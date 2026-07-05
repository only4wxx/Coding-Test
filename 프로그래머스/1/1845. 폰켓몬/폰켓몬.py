def solution(nums):
    answer = 0
    
    dict = {} # 종류당 폰켓몬 수 ('종류':'폰켓몬 수')
    for num in nums:
        if num in dict:
            dict[num] += 1
        else:
            dict[num] = 0
    
    N = len(nums)
    if N/2 < len(dict): # 종류가 뽑아야하는 폰켓몬 수보다 많음
        answer = N/2 # 모두 다 다른 종류
    else:
        answer = len(dict)
    
    return answer