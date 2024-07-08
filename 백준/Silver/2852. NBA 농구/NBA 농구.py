N = int(input())

winning_team = 0 # 현재 이기고 있는 팀(사실은 바로 이전까지 이기고 있었던 팀)을 기록
current_time = [0, 0] # 시간 측정을 위해 현재 시간(사실은 바로 이전 골을 넣었던 시간)을 측정
goal = [0, 0] # 각 팀의 골 횟수
team_time = [[0, 0], [0, 0]] # 각 팀이 이기고 있던 시간

def time_update(goal_team, goal_time):

    global winning_team
    # 현재까지 이기고 있었던 팀을 업데이트
    if goal[0] > goal[1]: # 1번 팀이 이기고 있었다면
        winning_team = 1
    elif goal[0] < goal[1]: # 2번 팀이 이기고 있었다면
        winning_team = 2
    else: # 비기고 있었다면
        winning_team = 0
    
    if goal_team == '1': # 1번 팀이 골을 넣었다면
        goal[0] += 1
    elif goal_team == '2': # 2번 팀이 골을 넣었다면
        goal[1] += 1
    
    # 이기고 있던 시간 측정
    winning_time = [0, 0]
    winning_time[0] = goal_time[0] - current_time[0]
    winning_time[1] = goal_time[1] - current_time[1]
    if winning_time[1] < 0:
        winning_time[0] -= 1
        winning_time[1] += 60
    
    # 이기고 있던 시간 업데이트
    if winning_team : # 비기고 있지 않았다면
        team_time[winning_team-1][0] += winning_time[0]
        team_time[winning_team-1][1] += winning_time[1]

    # 시간 업데이트
    current_time[0] = goal_time[0]
    current_time[1] = goal_time[1]

for n in range(N):
    goal_team, goal_time = input().split()
    goal_time = [int(goal_time[:2]), int(goal_time[3:])]
    time_update(goal_team, goal_time)
    # print(team_time)
time_update('0', [48, 0]) # 경기가 끝났을 때

outputs = []
for time in team_time: 
    # 시간 출력 형식 MM:SS
    time[0] += time[1] // 60
    time[1] %= 60
    hour = str(time[0])
    miniute = str(time[1])
    if len(hour) == 1: hour = '0' + hour
    if len(miniute) == 1: miniute = '0' + miniute
    outputs.append([hour, miniute])
# print(outputs)
for output in outputs:
    print(output[0]+':'+output[1])