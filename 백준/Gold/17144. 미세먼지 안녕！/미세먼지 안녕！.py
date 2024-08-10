# 17144
# 미세먼지 안녕!

from copy import deepcopy

R, C, T = map(int, input().split(' ')) # 격자판 RxC, T초 후의 상태
next_room = [] # 다음에 변화될 상태
for _ in range(R): next_room.append(list(map(int, input().split(' '))))
dir = [[-1, 0], [0, 1], [1, 0], [0, -1]] # 동서남북 방향

room = []
air_purifier = [] # 공기청정기 위치
for _ in range(T): # T초 동안 진행됨
    room = deepcopy(next_room)
    # 미세먼지 확산
    for r in range(R):
        for c in range(C):
            if room[r][c] > 0: # 해당 칸에 미세먼지가 있다면
                # 각 방향에 위치한 칸이 벽이 아니고, 공기청정기가 없다면 미세먼지 확산
                if r > 0 and room[r-1][c] > -1:
                    next_room[r-1][c] += room[r][c] // 5
                    next_room[r][c] -= room[r][c] // 5
                if c > 0 and room[r][c-1] > -1:
                    next_room[r][c-1] += room[r][c] // 5
                    next_room[r][c] -= room[r][c] // 5
                if r < R-1 and room[r+1][c] > -1:
                    next_room[r+1][c] += room[r][c] // 5
                    next_room[r][c] -= room[r][c] // 5
                if c < C-1 and room[r][c+1] > -1:
                    next_room[r][c+1] += room[r][c] // 5
                    next_room[r][c] -= room[r][c] // 5
            elif room[r][c] == -1: air_purifier.append([r, c])
    
    # 공기청정기 작동, 바람 순환
    # 반시계 방향 순환
    air_move = []
    r, c = air_purifier[0][0], air_purifier[0][1]
    for i in range(c+1, C-1): air_move.append([r, i])
    for i in range(r, 0, -1): air_move.append([i, C-1])
    for i in range(C-1, c, -1): air_move.append([0, i])
    for i in range(0, r): air_move.append([i, c])
    # print(air_move)
    for i in range(len(air_move)-1, 0, -1):
        next_room[air_move[i][0]][air_move[i][1]] = next_room[air_move[i-1][0]][air_move[i-1][1]]
    next_room[air_move[0][0]][air_move[0][1]] = 0

    # 시계 방향 순환
    air_move = []
    r, c = air_purifier[1][0], air_purifier[1][1]
    for i in range(c+1, C-1): air_move.append([r, i])
    for i in range(r, R-1): air_move.append([i, C-1])
    for i in range(C-1, c, -1): air_move.append([R-1, i])
    for i in range(R-1, r, -1): air_move.append([i, c])
    # print(air_move)
    for i in range(len(air_move)-1, 0, -1):
        next_room[air_move[i][0]][air_move[i][1]] = next_room[air_move[i-1][0]][air_move[i-1][1]]
    next_room[air_move[0][0]][air_move[0][1]] = 0
    
    # for r in range(R): print(next_room[r])

result = 0
for r in range(R):
    for c in range(C):
        if next_room[r][c] > 0: # 미세먼지가 있다면
            result += next_room[r][c] # 해당 미세먼지 값을 합산
print(result)