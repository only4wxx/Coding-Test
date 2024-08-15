# 17276
# 배열 돌리기

from copy import deepcopy

def rotate_45(array, n): # 배열을 시계 방향으로 45도 돌리는 함수
    result_array = deepcopy(array)
    for i in range(n):
        result_array[i][(n+1)//2-1] = array[i][i] # 주 대각선을 가운데 열로 옮김
        result_array[i][n-1-i] = array[i][(n+1)//2-1] # 가운데 열을 부 대각선으로 옮김
        result_array[(n+1)//2-1][n-1-i] = array[i][n-1-i] # 부 대각선을 가운데 행으로 옮김
        result_array[i][i] = array[(n+1)//2-1][i] # 가운데 행을 주 대각선으로 옮김
    return result_array

N = int(input()) # 테스트 케이스의 개수
result = [] # 결과값 리스트
for _ in range(N):
    n, d = map(int, input().split(' '))
    array = []
    for _ in range(n):
        array.append(list(map(int, input().split(' '))))
    
    if d < 0: d += 360 # 함수를 사용하기 위해 360도를 더해줌
    number = d // 45 # 45도로 몇 번 돌려야 하는지
    for _ in range(number):
        result_array = rotate_45(array, n)
        array = deepcopy(result_array)

    for i in range(n): result.append(array[i])

for i in range(len(result)): print(*(result[i]))