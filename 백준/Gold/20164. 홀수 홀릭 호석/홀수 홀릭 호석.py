# 20164
# 홀수 홀릭 호석

from itertools import combinations

result = [20, 0] # 결과 최솟값, 최댓값
def make_odd(number, res): # 로직을 실행

    if len(number) == 1: # 수가 한 자리
        if int(number) % 2 == 1: # 홀수라면
            res += 1
        
        if res < result[0]: result[0] = res # 최솟값인지 체크
        if res > result[1]: result[1] = res # 최댓값인지 체크
    
    elif len(number) == 2: # 수가 두 자리
        for num in number: # 홀수의 개수를 셈
            if int(num) % 2 == 1: # 홀수라면
                res += 1
        
        new_number = str(int(number[0]) + int(number[1])) # 2개로 나눠서 합을 구하여 새로운 수로 생각
        make_odd(new_number, res)
    
    else: # 수가 세 자리 이상
        for num in number: # 홀수의 개수를 셈
            if int(num) % 2 == 1: # 홀수라면
                res += 1
        
        section = list(combinations([i for i in range(1, len(number))], 2)) # 수를 분할시키는 위치의 경우의 수
        # print(section)
        for s1, s2 in section:
            new_number = str(int(number[:s1]) + int(number[s1:s2]) + int(number[s2:])) # 3개로 나눠서 합을 구하여 새로운 수로 생각
            make_odd(new_number, res)

N = str(input()) # 문자열로 입력을 받음
make_odd(N, 0)
print(*(result))