# 1449
# 수리공 항승

N, L = map(int, input().split(' ')) # 물이 새는 곳의 개수 N, 테이프의 길이 L
holes = list(map(int, input().split(' ')))
holes.sort() # 오름차순으로 정렬

output = 1 # 필요한 테이프의 수
tape = [holes[0]-0.5, holes[0]-0.5+L] # 가장 최근에 붙인 테이프가 붙여져 있는 위치
for i in range(1, N):
    # 해당 물이 새는 곳을 이 테이프로 막을 수 있는지 확인
    if holes[i]-0.5 >= tape[0] and holes[i]+0.5 <= tape[1]: # 막을 수 있다면
        continue # 패스
    else: # 막을 수 없다면
        output += 1 # 필요한 테이프를 하나 더 추가
        tape[0] = holes[i]-0.5
        tape[1] = holes[i]-0.5+L

print(output)