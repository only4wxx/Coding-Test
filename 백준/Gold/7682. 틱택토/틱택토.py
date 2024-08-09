# 7682
# 틱택토

def check(test, piece): # 해당 말이 3칸을 잇는데 성공했는지를 반환
    # 가로
    if piece == test[0] == test[1] == test[2]: return True
    if piece == test[3] == test[4] == test[5]: return True
    if piece == test[6] == test[7] == test[8]: return True
    # 세로
    if piece == test[0] == test[3] == test[6]: return True
    if piece == test[1] == test[4] == test[7]: return True
    if piece == test[2] == test[5] == test[8]: return True
    # 대각선
    if piece == test[0] == test[4] == test[8]: return True
    if piece == test[2] == test[4] == test[6]: return True

outputs = []
while True:
    test = input()
    if test == 'end': break
    
    # print(test[0:3])
    # print(test[3:6])
    # print(test[6:9])
    # print('-----------')

    num_X, num_O = 0, 0
    for t in test: # 각 말의 개수를 셈
        if t == 'X': num_X += 1
        elif t == 'O': num_O += 1
    
    if num_X - num_O == 1: # X가 O보다 1개 많은 경우 -> X가 승리 or 무승부
        if check(test, 'X'): # X가 성공한 경우
            if check(test, 'O'): outputs.append('invalid') # O도 성공했으면 invalid
            else: outputs.append('valid') # O가 실패했어야 가능
        else: # X가 실패한 경우
            if num_X + num_O < 9: outputs.append('invalid') # 게임판을 모두 채우지 못했으면 invalid
            elif check(test, 'O'): outputs.append('invalid') # O가 성공했으면 invalid
            else: outputs.append('valid') # O가 실패했어야 가능
    elif num_X == num_O: # X와 O의 개수가 같음 -> O가 승리
        if check(test, 'O'): # O가 성공한 경우
            if check(test, 'X'): outputs.append('invalid') # X도 성공했으면 invalid
            else: outputs.append('valid') # X가 실패했어야 가능
        else: # O가 실패한 경우
            outputs.append('invalid') # 불가능
    else: # 나머지 -> 불가능
        outputs.append('invalid')

for output in outputs: print(output)