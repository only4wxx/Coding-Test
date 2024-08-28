# 11057
# 오르막 수

N = int(input())

number = [1] * 10 # 첫번째 수에 따른 오르막 수를 세기 위한 리스트
result = sum(number)

for length in range(N-1): # 각 길이에 따라 계산

    next_number = [0] * 10 # 다음 길이에서, 두번째 자리수에 따른 오르막 수를 세기 위한 리스트
    for i in range(1, 10): # 첫번째 자리 수. 앞자리가 0인 경우는 이미 셌으므로 제외
        next_number[i] = sum(number[i:]) # 두번째 자리에 첫번째 자리 수와 같거나 큰 수가 와야 하므로 해당 개수를 세줌
    number = next_number.copy() # 다음 자리를 위해 리스트를 업데이트
    result += sum(number) # 수는 0으로 시작할 수 있으므로, 이전 자리수에 따른 오르막 수의 개수를 계속 더해줘야 함

print(result % 10007)