# 1283
# 단축키 지정

N = int(input())

shortcut = [] # 각 옵션의 단축키와, 해당 위치
def assign_shortcut(option):
    shortcut_key = list(map(lambda x: x[0], shortcut)) # 단축키들
    # print(shortcut_key)
    option = option.upper() # 대문자로 변환

    for i in range(len(option)):
        if i == 0 or option[i-1] == ' ': # 단어의 첫 글자
            if option[i] not in shortcut_key: # 단어의 첫 글자가 단축키로 지정되어 있지 않다면
                shortcut.append([option[i], i]) # 단축키와 해당 위치를 리스트에 저장
                return
    
    # 모든 단어의 첫 글자가 이미 단축키로 지정되어 있다면
    for i in range(len(option)):
        if option[i] != ' ' and option[i] not in shortcut_key: # 왼쪽에서부터 차례대로 알파벳을 보면서 단축키로 지정 안 된 것이 있다면
            shortcut.append([option[i], i]) # 단축키로 지정
            return
    
    # 어떠한 것도 단축키로 지정할 수 없다면 그냥 놔둠
    shortcut.append(['', -1])

options = []
for _ in range(N):
    option = input()
    assign_shortcut(option)
    options.append(option)
# print(shortcut)

for n in range(N): # 각 옵션에 단축키를 표시해서 출력
    index = shortcut[n][1] # 단축키가 있는 위치

    for i in range(len(options[n])): # 출력
        if i == index: # 단축키가 있는 알파벳을 출력할 때
            print('['+options[n][i]+']', end='')
        else: print(options[n][i], end='')
    print()