# 14719
# 빗물

H, W = map(int, input().split(' '))
blocks = list(map(int, input().split(' ')))

water = [0 for _ in range(W)] # 각 가로칸 한줄에 쌓이는 물의 양
left = 0 # 물이 고이기 위한 가장 높은 벽의 높이를 기록 -> 왼쪽 벽으로 간주
for i in range(W):
    if blocks[i] >= blocks[left]:
        left = i
    elif blocks[i] < blocks[left]:
        water[i] = blocks[left] - blocks[i]

# 오른쪽 벽이 없어서 고이지 않은 물을 체크해줌
right = W - 1 # 오른쪽에서부터 가장 높은 벽을 체크
for i in range(W-1, left, -1):
    if blocks[i] >= blocks[right]:
        right = i
        water[i] = 0
    elif blocks[i] < blocks[right]:
        water[i] = blocks[right] - blocks[i]

# print(water)
print(sum(water[1:W-1])) # 가장 왼쪽, 오른쪽 칸은 어차피 물이 고일 수 없으므로 빼고 계산