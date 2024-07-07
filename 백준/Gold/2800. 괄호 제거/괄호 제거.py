# 2800
# 괄호 제거
# 올바른 괄호 쌍을 제거해서 나올 수 있는 서로 다른 식을 사전 순으로 출력한다.

from itertools import combinations # 조합 사용

expression = list(input())

pairs = [] # 괄호 쌍
stack = [] # 괄호 매칭을 위한 스택
for i in range(len(expression)):
    # 괄호 쌍의 위치를 찾음
    if expression[i] == '(':
        stack.append(i)
    elif expression[i] == ')':
        pairs.append([stack.pop(), i])
# print(pairs)

cases = []
for num in range(1, len(pairs)+1):
    cases.append(list(combinations(pairs, num))) # 가능한 경우의 수

outputs = [] # 결과 출력값
for i in range(len(cases)): # n개를 포함한 조합마다 실행
    for j in range(len(cases[i])): # 각 경우의 수에 맞는 괄호를 뺌
        result = expression.copy()
        for n in range(len(cases[i][j])): # 해당 경우의 수에 해당하는 괄호를 모두 뺌
            result[cases[i][j][n][0]] = ''
            result[cases[i][j][n][1]] = ''
        outputs.append(''.join(result))

outputs = list(set(outputs)) # 중복 제거
outputs.sort() # 사전순으로 정렬
for output in outputs: print(output)