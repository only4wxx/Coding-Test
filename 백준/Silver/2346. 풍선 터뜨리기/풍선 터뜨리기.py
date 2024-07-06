# 2346
# 풍선 터뜨리기

N = int(input())

balloon = list(map(int, input().split(' ')))

point = 0 # 현재 터뜨릴 풍선
move = balloon[point]
balloon[point] = 0 # 해당 충선을 터뜨림
outputs = [1] # 출력값

for n in range(N-1):

    if move > 0: # 이동할 값이 양수라면
        for i in range(move): # 해당 풍선으로 이동
            point += 1
            if point == N: point = 0 # 풍선의 가장 오른쪽 다음은 맨 왼쪽 풍선

            while balloon[point] == 0: # 터져있는 풍선이었다면 안 터진 풍선까지 이동
                point += 1
                if point == N: point = 0 # 풍선의 가장 오른쪽 다음은 맨 왼쪽 풍선
                # print(point, end=" ")

    else: # 이동할 값이 음수라면
        for i in range(abs(move)): # 해당 풍선으로 이동
            point -= 1
            if point == -1: point = N-1 # 풍선의 가장 왼쪽 다음은 맨 오른쪽 풍선

            while balloon[point] == 0: # 터져있는 풍선이었다면 안 터진 풍선까지 이동
                point -= 1
                if point == -1: point = N-1 # 풍선의 가장 왼쪽 다음은 맨 오른쪽 풍선

    move = balloon[point] # 풍선 안에 있는 종이의 값
    # print('move ' + str(move))
    # print('point ' + str(point))

    balloon[point] = 0 # 해당 충선을 터뜨림
    outputs.append(point+1)

    # print(balloon)

for output in outputs: print(output, end=" ")