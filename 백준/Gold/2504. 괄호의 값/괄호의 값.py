# 2504
# 괄호의 값

parentheses = list(input())

output = 0 # 출력값
result = [] # 값을 계산하기 위한 리스트
point = 0 # 리스트에서의 위치를 체크하기 위함
stack = [] # 괄호쌍을 체크하기 위한 스택

for i in range(len(parentheses)):

    if parentheses[i] == '(':
        stack.append(['(', point]) # '('와 리스트 result에서의 위치도 함께 넣음
    elif parentheses[i] == ')':
        if not stack:
            result = []
            break
        else: next = stack.pop()

        if i > 0 and parentheses[i-1] == '(': # 괄호쌍이 맞음, 괄호열 안에 아무것도 없다면
            result.append(2) # '()' 인 괄호열의 값은 2
        elif next[0] == '(': # 괄호쌍이 맞음, 괄호열 안에 괄호열이 있다면
            total = sum(result[next[1]:]) * 2 # '(X)' 의 괄호값은 2×값(X) 으로 계산
            del result[next[1]:]
            result.append(total)
        else: # 괄호쌍이 맞지 않음
            result = []
            break
    
    elif parentheses[i] == '[':
        stack.append(['[', point]) # '('와 리스트 result에서의 위치도 함께 넣음
        point = len(result)
    elif parentheses[i] == ']':
        if not stack:
            result = []
            break
        else: next = stack.pop()
        if i > 0 and parentheses[i-1] == '[': # 괄호쌍이 맞음, 괄호열 안에 아무것도 없다면
            result.append(3) # '[]' 인 괄호열의 값은 3
        elif next[0] == '[': # 괄호쌍이 맞음, 괄호열 안에 괄호열이 있다면
            total = sum(result[next[1]:]) * 3 # '[X]' 의 괄호값은 3×값[X] 으로 계산
            del result[next[1]:]
            result.append(total)
        else: # 괄호쌍이 맞지 않음
            result = []
            break
    
    point = len(result)
    
    # print(i, end=' ')
    # print(parentheses[i], end=' ; ')
    # print(result, end=' ')
    # print(stack, end=' ')
    # print(point, end=' ')
    # print()

if stack: # 괄호가 닫히지 않은 경우
    result = []
    
output = sum(result)
print(output)