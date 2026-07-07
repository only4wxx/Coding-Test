def solution(number, k):
    answer = ''
    
    n = len(number) - k # 최종 숫자의 길이
    stack = []
    count = 0 # 뺀 숫자
    for i in range(len(number)):
        if count == k: # 더이상 제거할 수 없음
            stack.append(number[i])
            continue
        
        # 스택 최상단부터 숫자 교체
        while len(stack) > 0 and stack[-1] < number[i] and count < k:
            stack.pop()
            count += 1
        if len(stack) < n:
            stack.append(number[i])
            
    answer = ''.join(stack)
    
    return answer