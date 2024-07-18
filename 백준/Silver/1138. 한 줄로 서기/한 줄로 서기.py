# 1138
# 한 줄로 서기

N = int(input()) # 사람의 수
left_taller = list(map(int, input().split(' '))) # 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지

order = [ 0 for _ in range(N) ] # 사람의 수만큼의 크기를 가진 리스트 선언 -> 사람들이 줄 서는 위치를 나타낼 리스트임

for n in range(N): # 각 사람들마다 반복

    i = 0 # 앞에 자신보다 키 큰 사람을 몇 명 두어야 하는지를 세기 위해
    my_order = 0 # 자신의 위치를 찾기 위함
    while True:
        if order[my_order] != 0: # 해당 위치에 사람이 있으면(자신보다 작은 사람이 있는 경우)
            my_order += 1 # 해당 위치는 건너뜀

        elif i < left_taller[n]: # 왼쪽에 위치한 자신보다 큰 사람들의 수만큼 비우고 자신의 위치를 찾아야 함
            i += 1
            my_order += 1

        else: # 자신의 위치를 찾았다면
            order[my_order] = n + 1
            break

print(*(order))