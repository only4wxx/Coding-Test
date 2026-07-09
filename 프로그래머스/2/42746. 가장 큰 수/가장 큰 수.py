from functools import cmp_to_key

def solution(numbers):
    answer = ''
    
    numbers = list(map(str, numbers))
    numbers.sort(key = cmp_to_key(compare))
    
    isFirstZero = True # 앞에 0이 있으면 빼야함
    for i in range(len(numbers)):
        if isFirstZero and numbers[i] == '0':
            continue
        else: isFirstZero = False
        answer += numbers[i]
    if len(answer) == 0: answer = '0'
    
    return answer

def compare(a, b):
    if a + b < b + a:
        return 1
    elif a + b > b + a:
        return -1
    return 0