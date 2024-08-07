# 20055
# 컨베이어 벨트 위의 로봇

from collections import deque

N, K = map(int, input().split())
power = deque(map(int, input().split())) # 해당 칸의 내구도
belt = deque(0 for _ in range(N))
num = 0

while power.count(0) < K: # 내구도가 0인 칸이 K개 이상이라면 종료
    num += 1 # 해당 순서가 몇 번째인지

    # 벨트가 각 칸 위에 있는 로봇과 함께 회전
    power.rotate(1)
    belt.rotate(1)
    belt[0] = 0

    belt[N-1] = 0 # 내리는 위치에 있는 로봇을 내림
    for n in range(N-2, -1, -1): # 벨트에 가장 먼저 올라간 로봇부터 각 칸에 있는 로봇이 이동할 수 있는지 체크
        if belt[n] == 1 and belt[n+1] == 0 and power[n+1] > 0: # 이동하려는 칸에 로봇이 없고, 그 칸의 내구도가 1 이상 남아있어야 이동 가능
            # 로봇이 이동
            belt[n] = 0
            belt[n+1] = 1
            power[n+1] -= 1
    
    if power[0] > 0: # 올리는 위치에 있는 칸의 내구도가 0이 아니라면
        belt[0] = 1 # 올리는 칸에 로봇을 올림
        power[0] -= 1

    # print(power, end=" ")
    # print(belt)

print(num)