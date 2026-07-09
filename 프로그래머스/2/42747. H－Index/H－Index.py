def solution(citations):
    answer = 0
    n = len(citations)
    citations.sort()
    
    i = 0
    for h in range(citations[-1]+1):
        while citations[i] < h: # h번 이상 인용된 논문 시작점 찾기
            i += 1
        if n - i >= h: # h번 이상 인용된 논문이 h편 이상이라면
            answer = h
    
    return answer