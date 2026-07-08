def solution(progresses, speeds):
    answer = []
    
    days = [] # 해당 작업이 몇 day에 배포되는지
    for i in range(len(progresses)):
        left = 100 - progresses[i] # 남은 진행률
        # 배포 day 올림 계산 
        day = left // speeds[i]
        if day != left / speeds[i]:
            day += 1
        days.append(day)
        
    i = 0
    while i < len(days):
        count = 1 # 현재 배포 개수
        j = i + 1
        while j < len(days) and days[j] <= days[i]: # 현재 준비된 모든 기능
            j += 1
            count += 1
        i = j
        answer.append(count)
    
    return answer