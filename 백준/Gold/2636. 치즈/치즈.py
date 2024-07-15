# 2636
# 치즈

import sys
sys.setrecursionlimit(5000) # 재귀 깊이 변경

H, W = map(int, input().split()) # 세로와 가로

cheeze = []
for _ in range(H): cheeze.append(list(map(int, input().split())))

next_melt = [] # 다음으로 녹을 치즈 조각의 위치
def melting(h, w): # 해당 위치 주변에 다음에 녹을 치즈 조각이 있는지를 찾음
    cheeze[h][w] = -1 # 이미 체크했다는 의미
    if h > 0:
        if cheeze[h-1][w] == 0:
            melting(h-1, w)
        elif cheeze[h-1][w] == 1:
            next_melt.append([h-1, w])

    if w > 0:
        if cheeze[h][w-1] == 0:
            melting(h, w-1)
        elif cheeze[h][w-1] == 1:
            next_melt.append([h, w-1])

    if h < H-1:
        if cheeze[h+1][w] == 0:
            melting(h+1, w)
        elif cheeze[h+1][w] == 1:
            next_melt.append([h+1, w])

    if w < W-1:
        if cheeze[h][w+1] == 0:
            melting(h, w+1)
        elif cheeze[h][w+1] == 1:
            next_melt.append([h, w+1])
    
finish_time = 0 # 치즈가 모두 녹아 없어지는 데 걸리는 시간
while True:
    melting(0, 0)
    if finish_time == 0 and len(next_melt) == 0: # 처음부터 녹을 치즈 조각이 없었던 경우
        break

    for melt in next_melt: # 다음으로 녹아야 할 치즈 조각들을 녹임
        cheeze[melt[0]][melt[1]] = 0
    
    is_finish = True # 남은 모든 조각이 녹을 예정인지 체크 -> 1이 하나도 없으면 멈춰야 함
    # -1인 것들 0으로 바꾸기
    for h in range(H):
        for w in range(W):
            if cheeze[h][w] == -1: cheeze[h][w] = 0
            elif cheeze[h][w] == 1: is_finish = False
    
    finish_time += 1
    if is_finish == True: break

    next_melt = [] # 다음에 녹을 치즈 조각의 위치를 담기 위해 초기화

    # for x in range(len(cheeze)): print(cheeze[x])

print(finish_time) # 치즈가 모두 녹는 데에 걸리는 시간

next_melt = set(map(tuple, next_melt)) # 중복을 제거한 후 개수를 출력
print(len(next_melt))