# 1325
# 효율적인 해킹

from collections import deque

N, M = map(int, input().split(' ')) # N개의 컴퓨터, M개 줄 입력
trust = [ [] for _ in range(N+1) ] # 각 컴퓨터를 신뢰하는 컴퓨터들. 해당 컴퓨터를 해킹하면 함께 해킹할 수 있는 컴퓨터
for _ in range(M):
    A, B = map(int, input().split(' ')) # A가 B를 신뢰
    trust[B].append(A) # B를 해킹하면 A도 해킹할 수 있음
# for n in range(1, len(trust)):
#     print(n, end=" ")
#     print(trust[n])

outputs = []
max_hacking = 0
def bfs(trust, start):
    global max_hacking
    result = 0 # 해당 컴퓨터를 해킹하면 한 번에 해킹할 수 있는 모든 컴퓨터의 개수
    visited = [False] * (N+1)
    queue = deque([start])
    visited[start] = True
    while queue:
        # print(hacking[start])
        # print(queue)
        computer = queue.popleft()
        for com in trust[computer]:
            if not visited[com]:
                visited[com] = True
                result += 1
                queue.append(com)
    if result > max_hacking:
        outputs.clear()
        outputs.append(start)
        max_hacking = result
    elif result == max_hacking: outputs.append(start)

for computer in range(1, N+1): bfs(trust, computer)
# print(hacking)

# 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터를 찾음
print(*(outputs))