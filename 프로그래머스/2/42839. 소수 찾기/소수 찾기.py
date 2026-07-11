import itertools

def solution(numbers):
    answer = 0
    arr_num = []
    for number in numbers:
        arr_num.append(number)
    
    all_nums = []
    for n in range(1, len(numbers)+1):
        all_nums = list(set(itertools.permutations(arr_num, n)))
        for num in all_nums:
            number = ''.join(num)
            if number[0] != '0' and isPrime(int(number)):
                # print(number)
                answer += 1
    
    return answer

def isPrime(number):
    if number <= 1:
        return False
    
    n = int(number ** 0.5)
    for i in range(2, n+1):
        if number / i == number // i:
            return False
    return True