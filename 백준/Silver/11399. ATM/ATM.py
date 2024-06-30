N = int(input())

num_list = list(map(int, input().split(' ')))
num_list.sort() # 오름차순으로 정렬
# print(num_list)

time = 0 # 누적 시간
result = 0
for num in num_list:
    time += num # 현재 사람이 돈을 뽑는 데에 걸리는 시간
    result += time # 모든 사람이 돈을 인출하는 데 걸리는 시간을 구함

print(result)