# 1260
# DFS와 BFS

from collections import deque

DFS_visited = [] # DFS를 수행한 결과
def dfs(graph, start):
    if start in DFS_visited: return # 이미 방문한 노드
    
    DFS_visited.append(start)
    for node in graph[start]: dfs(graph, node) # 해당 노드와 연결된 노드로 DFS를 계속함

BFS_visited = [] # BFS를 수행한 결과
def bfs(graph, start):
    queue = deque([start])
    while queue:
        node = queue.popleft()
        if node not in BFS_visited: # 아직 방문한 적 없는 노드만 탐색
            BFS_visited.append(node)
            for n in graph[node]: queue.append(n)


N, M, V = map(int, input().split(' '))
graph = [ [] for _ in range(N+1) ] # 각 정점과 연결된 정점들
for _ in range(M):
    n1, n2 = map(int, input().split(' '))
    graph[n1].append(n2)
    graph[n2].append(n1)
for n in range(1, N+1): graph[n].sort()

dfs(graph, V)
bfs(graph, V)
print(*(DFS_visited))
print(*(BFS_visited))