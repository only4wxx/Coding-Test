def solution(name):
    # 처음에 AAAA 이런 식으로 되어있고 조이스틱 움직여서 각 글자마다 바꾸기
    # ABCDEFGHIJKLMNOPQRSTUVWXYZ 순인 듯
    answer = 0
    n = len(name)
    
    move = n - 1 # 기본은 왼쪽부터 오른쪽으로 쭉 가는 거
    for i in range(n):
        # 알파벳 변경 횟수 계산
        num = ord(name[i]) - ord('A') # 위로 조작하는 횟수
        if num > 13:
            num = 26 - num # 아래로 조작하는 횟수
        answer += num
    
        # 커서 이동 횟수 계산
        next_i = i + 1
        while next_i < n and name[next_i] == 'A': # 해당 위치부터 연속된 A의 끝자리 찾기
            next_i += 1
        
        move = min(
            move,
            i * 2 + (n - next_i), # 오른쪽으로 갔다가 돌아와서 왼쪽
            i + (n - next_i) * 2 # 왼쪽으로 갔다가 돌아와서 오른쪽
        )
    
    answer += move # 커서 횟수 더하기
    
    return answer