# 17626
# Four Squares

import math

N = int(input())
start = int(N**0.5)
memo = dict()

# 초기값 설정
# for n in range(1, start+1): dp[0][n**2] = 1 # 제곱수
for n in range(1, start+1): memo[n**2] = 1 # 제곱수
memo[2] = 2
memo[3] = 3

def find_square(num):
    if num in memo.keys(): return memo[num] # 값을 이미 구했었다면

    max_square = int(num**0.5) # 제곱수의 합이 되어야 하므로 가장 큰 제곱수를 구함
    # print('num: '+str(num), end=' / ')
    # print(max_square)

    min_result = 0
    for n in range(max_square, max_square//2-1, -1): # 최소 개수를 구함
        result_square = find_square(num-n**2)
        if not min_result: min_result = 1 + result_square
        elif result_square+1 < min_result: min_result = 1 + result_square
    memo[num] = min_result
    return min_result

print(find_square(N))
# print(memo)