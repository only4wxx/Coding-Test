# 21608
# 상어 초등학교

N = int(input())
students = []
for _ in range(N**2):
    students.append(list(map(int, input().split(' ')))) # 각 학생의 번호, 좋아하는 학생의 번호들의 리스트를 입력받음

my_seat = dict() # 학생의 번호:학생의 위치 로 구성된 딕셔너리
for student in students:
    seat = [[0 for _ in range(N)] for _ in range(N)] # 각 자리, 각 자리의 값은 해당 위치에 인접한 좋아하는 학생의 수
    for location in my_seat.values(): # 이미 자리가 찬 곳을 채워줌
        seat[location[0]][location[1]] = -1

    # 1. 좋아하는 학생이 인접한 칸이 가장 많은 자리를 찾음
    for like_student in student[1:]: # 해당 학생이 좋아하는 학생들의 번호
        if like_student in my_seat.keys(): # 좋아하는 학생이 이미 자리를 잡았다면
            # 그 학생의 인접한 자리의 값을 1 증가시킴
            r, c = my_seat[like_student][0], my_seat[like_student][1]
            if r > 0 and seat[r-1][c] != -1: seat[r-1][c] += 1
            if r < N-1 and seat[r+1][c] != -1: seat[r+1][c] += 1
            if c > 0 and seat[r][c-1] != -1: seat[r][c-1] += 1
            if c < N-1 and seat[r][c+1] != -1: seat[r][c+1] += 1
    
    max_like_student = max(map(max, seat)) # 인접한 좋아하는 학생의 수 중 가장 큰 값
    candidates = [] # 해당 학생의 후보 자리
    for r in range(N):
        for c in range(N):
            if seat[r][c] == max_like_student: candidates.append([[r, c], 0])
    
    # 2. 1을 만족하는 칸 중, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸
    for i in range(len(candidates)):
        # 해당 칸의 인접한 칸 중 비어있는 칸의 개수를 셈
        r, c = candidates[i][0][0], candidates[i][0][1]
        if r > 0 and seat[r-1][c] != -1: candidates[i][1] += 1
        if r < N-1 and seat[r+1][c] != -1: candidates[i][1] += 1
        if c > 0 and seat[r][c-1] != -1: candidates[i][1] += 1
        if c < N-1 and seat[r][c+1] != -1: candidates[i][1] += 1

    # 3. 2를 만족하는 칸 중, 행의 번호가 가장 작은 칸, 그 중 열의 번호가 가장 작은 칸
    candidates.sort(key=lambda x: (-x[1], x[0][0], x[0][1]))
    my_seat[student[0]] = [candidates[0][0][0], candidates[0][0][1]]

# print(my_seat)

# 학생의 만족도 총 합을 출력
# 해당 학생과 인접한 칸에 앉은 좋아하는 학생의 수가 0이면 만족도가 0, 1이면 1, 2이면 10, 3이면 100, 4이면 1000
result = 0
for student in students:
    num_like_student = 0 #  인접한 좋아하는 학생의 수
    
    r,c = my_seat[student[0]][0], my_seat[student[0]][1] # 해당 학생의 위치
    for like_student in student[1:]: # 좋아하는 학생들의 위치를 확인
        if abs(r-my_seat[like_student][0])+abs(c-my_seat[like_student][1]) == 1: # 인접해 있다면
            num_like_student += 1
    
    if num_like_student == 1: result += 1
    elif num_like_student == 2: result += 10
    elif num_like_student == 3: result += 100
    elif num_like_student == 4: result += 1000
print(result)