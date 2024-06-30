N = int(input())

num_list = list(map(int, input().split(' ')))
num_list.sort() # 오름차순으로 정렬
# print(num_list)

if N % 2 == 1: # 홀수개인 경우
    result = num_list[N//2] # 중앙값
else: # 짝수개인 경우
    num1 = N//2-1 # 중앙값 중 작은 것
    num2 = N//2 # 중앙값 중 큰 것

    num1_diffrence = sum(num_list[0:num1]) - num_list[num1] * num1 + num_list[num1] * (N-1-num1) - sum(num_list[num1+1:N])
    num2_diffrence = sum(num_list[0:num2]) - num_list[num2] * num2 + num_list[num2] * (N-1-num2) - sum(num_list[num2+1:N])

    # 둘 중 더 작은 값을 찾음
    if num1_diffrence <= num2_diffrence:
        result = num_list[num1]
    else:
        result = num_list[num2]

print(result)