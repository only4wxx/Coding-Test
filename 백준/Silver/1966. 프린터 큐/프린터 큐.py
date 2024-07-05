# 1966
# 프린터 큐

from collections import deque

N = int(input())

outputs = [] # 출력값

for n in range(N):
    num, document = map(int, input().split(' ')) # 문서의 개수, 인쇄 순서가 궁금한 문서의 위치(0부터 시작)
    importance = deque(map(int, input().split(' '))) # 각 문서의 중요도

    result = 1 # 궁금한 문서가 인쇄되는 순서 결과값
    while True:
        max_importance = importance.index(max(importance)) # 현재 문서들 중 가장 높은 중요도를 가진 문서의 위치
        if max_importance == document: break # 궁금한 문서가 인쇄될 순서라면 종료
        else: result += 1

        for i in range(max_importance): # 해당 문서가 가장 앞에 오도록 재배치
            importance.append(importance.popleft())
            document -= 1
            if document < 0: document += num
        importance[0] = 0 # 해당 문서의 중요도를 0으로 바꿈 => 인쇄했다는 의미
    
    outputs.append(result)

for output in outputs: print(output)