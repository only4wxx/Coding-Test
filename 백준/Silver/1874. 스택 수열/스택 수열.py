N = int(input())

sequence = []
for i in range(N):
    sequence.append(int(input()))

def stack_sequence(sequence):
    stack = [0]
    number = 1 # 스택에 쌓을 숫자
    result = [] # push, pop 기록
    
    for num in sequence: # 수열의 각 수를 만들 수 있는지 체크
        while True:
            if stack[-1] == num: # 스택의 가장 위 숫자가 해당 숫자이면
                stack.pop() # 스택에서 pop
                result.append('-')
                break
            elif stack[-1] < num: # 스택의 가장 위 숫자보다 해당 숫자가 크면
                stack.append(number) # 스택에 push
                result.append('+')
                number += 1
            else: # 해당 수열을 만들 수 없음
                return ['NO']
    
    return result

result = stack_sequence(sequence)
for element in result: print(element) 