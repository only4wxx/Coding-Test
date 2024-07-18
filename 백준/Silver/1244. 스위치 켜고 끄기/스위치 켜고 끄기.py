# 1244
# 스위치 켜고 끄기

num_of_switches = int(input()) # 스위치의 개수
switches = list(map(int, input().split(' '))) # 각 스위치의 상태

def switch_change(switch): # 해당 번호의 스위치의 상태를 바꾸는 함수
    if switches[switch] == 1: switches[switch] = 0 # 켜져있다면 꺼줌
    elif switches[switch] == 0: switches[switch] = 1 # 꺼져있다면 켜줌

N = int(input()) # 학생 수
for _ in range(N):
    gender, number = map(int, input().split(' ')) # 학생의 성별, 학생이 받은 수
    number -= 1 # 스위치의 번호를 인덱스에 맞추기 위해 1을 빼줌

    if gender == 1: # 남학생이라면
        # 스위치 번호가 자기가 받은 수의 배수이면 그 스위치의 상태를 바꾼다.
        for switch in range(number, num_of_switches, number+1): # 배수를 찾기 위해 범위를 학생이 받은 수로 설정
            switch_change(switch)
    
    elif gender == 2: # 여학생이라면
        # 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에속한 스위치의 상태를 모두 바꿈
        switch_change(number) # 자기가 받은 번호의 스위치의 상태를 바꿈
        i = 1
        while number-i >= 0 and number+i < num_of_switches: # 조건을 충족하는 가장 많은 스위치를 찾기 위함
            if switches[number-i] == switches[number+i]: # 대칭이라면 스위치의 상태를 바꿈
                switch_change(number-i)
                switch_change(number+i)
                i += 1
            else: # 대칭이 아니라면
                break # 종료

for i in range(num_of_switches):
    print(switches[i], end=" ")
    if (i+1) % 20 == 0: # 한 줄에 20개씩 출력해야 하므로 20개가 넘어가면
        print() # 공백 추가