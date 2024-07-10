# 20006
# 랭킹전 대기열

p, m = map(int, input().split()) # 플레이어의 수, 방의 정원

rooms = [] # 각 게임 방에 입장한 플레이어
def entrance(player): # 플레이어를 게임 방에 입장시키는 함수
    for r in range(len(rooms)):
        # 해당 방에 처음 입장한 플레이어의 레벨을 기준으로 -10부터 +10까지 입장 가능, 방의 정원이 찰 때까지 입장 가능
        if player[0] <= rooms[r][0][0] + 10 and player[0] >= rooms[r][0][0] - 10 and len(rooms[r]) < m:
            rooms[r].append(player) # 플레이어를 입장시킴
            return
    
    # 들어갈 수 있는 방이 없다면
    rooms.append([player]) # 새로운 방 생성
            
for i in range(p):
    player = list(input().split()) # 플레이어의 레벨, 플레이어 아이디
    player[0] = int(player[0])
    entrance(player)
    # print(rooms)

for room in rooms: # 각 방이 시작되었는지, 대기 중인지 출력 후 방에 있는 플레이어 출력
    room = sorted(room, key=lambda x:x[1]) # 닉네임 사전 순으로 출력

    if len(room) == m: # 방의 정원이 다 찼다면
        print('Started!')
    else: # 방이 대기중이라면
        print('Waiting!')
    
    for player in room: # 해당 방에 있는 플레이어 출력
        print(str(player[0])+' '+player[1])