# 14503
# 로봇 청소기

N, M = map(int, input().split(' ')) # N개의 줄, M개의 칸
r, c, dir = map(int, input().split(' ')) # 로봇 청소기의 위치(r, c), 바라보는 방향

room = []
for _ in range(N): # 방의 상태를 입력받음
    room.append(list(map(int, input().split(' '))))
# print(room)

result = 0 # 청소하는 칸의 개수
directions = [[-1, 0], [0, 1], [1, 0], [0, -1]] # 순서대로 북, 동, 남, 서 -> 시계 방향 순
def clean_room(r, c, dir):
    # print(room)

    if room[r][c] == 0: # 현재 칸이 아직 청소되지 않은 경우
        room[r][c] = 2 # 현재 칸을 청소한다
        global result
        result += 1
    
    for d in directions: # 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 있는지 확인
        if room[r+d[0]][c+d[1]] == 0: # 청소되지 않은 빈칸이 있다면
            dir -= 1 # 반시계 방향으로 90도 회전
            if dir < 0: dir += 4

            if room[r+directions[dir][0]][c+directions[dir][1]] == 0: # 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우
                # 한 칸 전진
                r += directions[dir][0]
                c += directions[dir][1]
            
            clean_room(r, c, dir) # 과정 반복
            return
    
    # 현재 칸의 주변 4칸 중 청소되지 않은 빈칸이 없다면
    if room[r+directions[(dir+2)%4][0]][c+directions[(dir+2)%4][1]] != 1: # 바라보는 방향을 기준으로 후진할 수 있다면
        # 후진
        r += directions[(dir+2)%4][0]
        c += directions[(dir+2)%4][1]
        clean_room(r, c, dir) # 과정 반복
        return
    else: # 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면
        return # 작동을 멈춤

clean_room(r, c, dir)
print(result)