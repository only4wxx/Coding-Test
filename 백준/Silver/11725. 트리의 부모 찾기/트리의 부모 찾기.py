# 11725
# 트리의 부모 찾기

from collections import deque

def find_parent(graph, start):
    parent = [0 for _ in range(len(graph))] # 각 노드의 부모 노드
    visited = [] # 탐색한 노드를 체크하기 위해
    queue = deque([start])
    while queue:
        node = queue.popleft()
        visited.append(node)
        for n in graph[node]:
            if not parent[n]: # 아직 탐색하지 않은 노드라면(부모 노드가 설정되지 않은 노드라면)
                queue.append(n)
                parent[n] = node # 해당 노드의 부모 노드를 설정

        # print(node, end=' ')
        # print(parent, end=' ')
        # print(queue)
    return parent

N = int(input())
graph = [ [] for _ in range(N+1) ] # 각 노드와 연결된 노드들
for _ in range(N-1):
    n1, n2 = map(int, input().split(' '))
    graph[n1].append(n2)
    graph[n2].append(n1)

parent = find_parent(graph, 1)
for i in range(2, N+1): print(parent[i])