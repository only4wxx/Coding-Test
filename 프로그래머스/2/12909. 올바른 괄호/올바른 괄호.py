def solution(s):
    answer = True
    
    i = 0
    stack = [] # 왼쪽 괄호 넣을 스택
    for i in range(len(s)):
        if s[i] == '(':
            stack.append('(')
        elif s[i] == ')':
            if stack: # 왼쪽 괄호가 있다면
                stack.pop()
            else: # 왼쪽 괄호가 없다면
                answer = False # 올바르지 않음
                break
        i += 1
    if len(stack) > 0:
        answer = False
        
    return answer