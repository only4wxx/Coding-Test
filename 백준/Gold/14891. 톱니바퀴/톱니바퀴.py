# 14891
# 톱니바퀴
# 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 콥니의 극이 다르다면,
# B는 A기 회전한 반대방향으로 회전하게 된다.
# => '회전하기 전 기준!!!' 맞닿은 극이 다르면 회전, 같으면 회전 안함

from collections import deque

wheels = []
for i in range(4):
    wheels.append(deque(map(int, list(input()))))
# print(wheels)

N = int(input())

for n in range(N):
    wheel, direction = map(int, input().split())

    rotate = [0, 0, 0, 0] # 각 톱니바퀴가 회전할 방향

    if wheel == 1: # 1번 톱니바퀴가 회전했다면
        rotate[0] = direction # 1번 톱니바퀴는 입력으로 들어온 방향으로 회전
        if wheels[0][2] != wheels[1][6]: # 1번과 2번 톱니바퀴 사이 맞닿은 극이 다르면
            rotate[1] = (-1) * rotate[0] # 반대 방향으로 회전시킴
            if wheels[1][2] != wheels[2][6]: # 2번과 3번 톱니바퀴 사이 맞닿은 극이 다르면
                rotate[2] = (-1) * rotate[1] # 반대 방향으로 회전시킴
                if wheels[2][2] != wheels[3][6]: # 3번과 4번 톱니바퀴 사이 맞닿은 극이 다르면
                    rotate[3] = (-1) * rotate[2] # 반대 방향으로 회전시킴
    
    elif wheel == 2: # 2번 톱니바퀴가 회전했다면
        rotate[1] = direction # 2번 톱니바퀴는 입력으로 들어온 방향으로 회전
        if wheels[1][6] != wheels[0][2]: # 2번과 1번 톱니바퀴 사이 맞닿은 극이 다르면
            rotate[0] = (-1) * rotate[1] # 반대 방향으로 회전시킴
        if wheels[1][2] != wheels[2][6]: # 2번과 3번 톱니바퀴 사이 맞닿은 극이 다르면
            rotate[2] = (-1) * rotate[1] # 반대 방향으로 회전시킴
            if wheels[2][2] != wheels[3][6]: # 3번과 4번 톱니바퀴 사이 맞닿은 극이 다르면
                rotate[3] = (-1) * rotate[2] # 반대 방향으로 회전시킴
    
    elif wheel == 3: # 3번 톱니바퀴가 회전했다면
        rotate[2] = direction # 3번 톱니바퀴는 입력으로 들어온 방향으로 회전
        if wheels[2][6] != wheels[1][2]: # 3번과 2번 톱니바퀴 사이 맞닿은 극이 다르면
            rotate[1] = (-1) * rotate[2] # 반대 방향으로 회전시킴
            if wheels[1][6] != wheels[0][2]: # 2번과 1번 톱니바퀴 사이 맞닿은 극이 다르면
                rotate[0] = (-1) * rotate[1] # 반대 방향으로 회전시킴
        if wheels[2][2] != wheels[3][6]: # 3번과 4번 톱니바퀴 사이 맞닿은 극이 다르면
            rotate[3] = (-1) * rotate[2] # 반대 방향으로 회전시킴

    elif wheel == 4: # 4번 톱니바퀴가 회전했다면
        rotate[3] = direction # 4번 톱니바퀴는 입력으로 들어온 방향으로 회전
        if wheels[3][6] != wheels[2][2]: # 4번과 3번 톱니바퀴 사이 맞닿은 극이 다르면
            rotate[2] = (-1) * rotate[3] # 반대 방향으로 회전시킴
            if wheels[2][6] != wheels[1][2]: # 3번과 2번 톱니바퀴 사이 맞닿은 극이 다르면
                rotate[1] = (-1) * rotate[2] # 반대 방향으로 회전시킴
                if wheels[1][6] != wheels[0][2]: # 2번과 1번 톱니바퀴 사이 맞닿은 극이 다르면
                    rotate[0] = (-1) * rotate[1] # 반대 방향으로 회전시킴

    # print(rotate)
    # 해당 방향에 따라 톱니바퀴를 회전시킴
    for i in range(4):
        if rotate[i] == 1: # 시계 방향 회전이라면
            wheels[i].appendleft(wheels[i].pop())
        elif rotate[i] == -1: # 반시게 방향 회전이라면
            wheels[i].append(wheels[i].popleft())

# for i in range(4):
#     print(list(wheels[i]))
print(wheels[0][0] + wheels[1][0]*2 + wheels[2][0]*4 + wheels[3][0]*8)