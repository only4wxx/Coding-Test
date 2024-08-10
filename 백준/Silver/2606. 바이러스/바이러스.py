# 2606
# 바이러스

from collections import deque

computer = set([1]) # 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수

num_computer = int(input())
N = int(input())
computer = [ [] for _ in range(num_computer) ] # 각 컴퓨터와 연결되어 있는 컴퓨터
for _ in range(N):
    com1, com2 = map(int, input().split(' '))
    computer[com1-1].append(com2-1)
    computer[com2-1].append(com1-1)
# print(computer)

visited = [] # 이미 체크한 컴퓨터
queue = deque([0]) # 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터
while queue:
    start = queue.popleft()
    if start not in visited: # 체크 안 한 컴퓨터라면
        visited.append(start)
        for com in computer[start]: queue.append(com)

print(len(visited)-1) # 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수