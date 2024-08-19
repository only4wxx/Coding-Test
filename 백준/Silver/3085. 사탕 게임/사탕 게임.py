# 3085
# 사탕 게임

from copy import deepcopy

result = 0
def check_candy(candy):
    global result

    for x in range(N):
        color = ''

        # 행 체크
        number = 0
        for y in range(N):
            if candy[x][y] == color: # 연속된 사탕이라면
                number += 1
            else: # 연속된 사탕이 아니라면
                if result < number: result = number # 최대 개수 업데이트
                number = 1 # 처음부터 다시 셈
                color = candy[x][y]
        if result < number: result = number # 최대 개수 업데이트
        
        # 열 체크
        number = 0
        for y in range(N):
            if candy[y][x] == color: # 연속된 사탕이라면
                number += 1
            else: # 연속된 사탕이 아니라면
                if result < number: result = number # 최대 개수 업데이트
                number = 1 # 처음부터 다시 셈
                color = candy[y][x]
        if result < number: result = number # 최대 개수 업데이트

N = int(input())
candy = []
for _ in range(N):
    candy.append(list(input()))
# print(candy)

for x in range(N):
    for y in range(N):
        # 행을 바꿈
        if x < N-1:
            ex_candy = deepcopy(candy)
            ex_candy[x][y], ex_candy[x+1][y] = candy[x+1][y], candy[x][y]
            # for i in range(len(ex_candy)): print(ex_candy[i])
            check_candy(ex_candy)

        # 열을 바꿈
        if y < N-1:
            ex_candy = deepcopy(candy)
            ex_candy[x][y], ex_candy[x][y+1] = candy[x][y+1], candy[x][y]
            # for i in range(len(ex_candy)): print(ex_candy[i])
            check_candy(ex_candy)

print(result)