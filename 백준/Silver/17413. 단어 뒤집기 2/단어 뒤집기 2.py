# 17413
# 단어 뒤집기

string = input()

stack = [] # '<', '>', 문자를 담을 스택
result = [] # 결과 문자열
for element in string:
    if element == '<':
        while stack: result.append(stack.pop()) # 단어를 뒤집어서 저장
        stack.append('<')
        result.append('<')
    elif element == '>':
        stack.pop() # 여기까지 태그
        result.append('>')
    elif element == ' ':
        if stack and stack[0] == '<': # 태그라면
            result.append(' ') # 뒤집기 없이 저장
        else: # 단어라면
            while stack: result.append(stack.pop()) # 단어를 뒤집어서 저장
            result.append(' ')
    else: # 문자
        if stack and stack[0] == '<': # 태그라면
            result.append(element) # 뒤집지 않고 저장
        else: # 단어라면
            stack.append(element)
if stack and stack[0] == '<':
    result.append('>')
else:
    while stack: result.append(stack.pop()) # 단어를 뒤집어서 저장

print(''.join(result))