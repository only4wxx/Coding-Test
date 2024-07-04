# 5397
# 키로거

N = int(input())
result = []

for i in range(N): # 각 테스트 케이스마다 실행
    user_input = input() # 사용자의 입력
    
    # 커서를 기준으로 왼쪽 오른쪽 나눔
    left = []
    right = [] # 스택을 사용하기 위해 right는 역순으로

    for word in user_input:
        if word == '<': # 커서를 왼쪽으로 이동
            if left: # 왼쪽 문자열이 있다면
                right.append(left.pop())
        elif word == '>': # 커서를 오른쪽으로 이동
            if right: # 오른쪽 문자열이 있다면
                left.append(right.pop())
        elif word == '-': # 백스페이스로 문자를 지움
            if left: # 왼쪽 문자열이 있다면
                left.pop()
        else: # 문자 입력
            left.append(word)
        # print(password, end=' ')
        # print(curser)

    result.append(''.join(left) + ''.join(reversed(right))) # 리스트를 하나의 최종 비밀번호 문자열로 바꿈

for password in result: print(password)