# 1051
# 숫자 정사각형

def find_square(n, m):
    number = rectangle[n][m] # 기준이 될 숫자
    edge = 1 # 변의 길이
    max_edge = 0 # 정사각형의 변 길이 최대값
    while n+edge< N and m+edge < M: # 직사각형 안에서 진행
        if number == rectangle[n+edge][m] == rectangle[n][m+edge] == rectangle[n+edge][m+edge]: # 꼭짓점에 쓰여 있는 수가 모두 같은 정사각형을 찾는다면
            max_edge = edge
        edge += 1
    return max_edge

N, M = map(int, input().split(' '))
rectangle = []
for _ in range(N):
    rectangle.append(list(input()))
# print(rectangle)

result_edge = 0
for n in range(N):
    for m in range(M):
        # 모든 위치에서 시작하여 정사각형을 찾음
        max_edge = find_square(n, m)
        if max_edge > result_edge: result_edge = max_edge
print((result_edge+1)**2)