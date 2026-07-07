def solution(n, lost, reserve):
    answer = 0
    students = [1] * (n+1) # 1부터 시작하도록 n+1 크기 배열
    students[0] = 0
    
    for i in lost:
        students[i] -= 1
    for i in reserve:
        students[i] += 1
    
    for i in range(1, n):
        if students[i] == 0: # 체육복이 없는 경우
            if students[i+1] == 2: # 다음사람한테 빌리기
                students[i] = 1
                students[i+1] = 1
        elif students[i] == 2: # 체육복 여분 있는 경우
            if students[i+1] == 0: # 다음사람 빌려주기
                students[i] = 1
                students[i+1] = 1
    
    # 체육복 있는 학생 수 세기
    for student in students:
        if student > 0:
            answer += 1
    
    return answer