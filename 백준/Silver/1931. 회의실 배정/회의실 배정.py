# 1931
# 회의실 배정

N = int(input())

meetings = []
for n in range(N):
    start, end = map(int, input().split(' '))
    meetings.append([start, end])

meetings.sort(key=lambda x:(x[1], x[0])) # 끝나는 시간을 기준으로 정렬 후 시작하는 시간을 기준으로 정렬
# print(meetings)

last_time = 0 # 현재 회의가 끝나는 시간
result = 0
for meeting in meetings:
    if last_time <= meeting[0]: # 해당 회의를 시작할 수 있다면
        result += 1 # 회의 시작
        last_time = meeting[1] # 회의 끝나는 시간 업데이트
    
print(result)