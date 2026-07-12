from collections import deque

def solution(maps):
    answer = 0
    
    answer = bfs(maps, [0, 0])
    
    return answer

def bfs(maps, start):
    direction = [[0, 1], [-1, 0], [0, -1], [1, 0]]
    
    queue = deque([[start, 1]]) # 시작 위치랑 이동 칸 개수를 넣음
    while queue:
        node = queue.popleft()
        point = node[0] # 현재 위치
        count = node[1] # 이동 칸 개수
        
        for d in direction:
            x = point[0] + d[0]
            y = point[1] + d[1]
            
            # 해당 칸으로 이동
            if x > -1 and x < len(maps) and y > -1 and y < len(maps[0]) and maps[x][y] == 1:
                if x == len(maps)-1 and y == len(maps[0])-1: # 도착점이라면
                    return count + 1
                queue.append([[x, y], count+1])
                maps[x][y] = 0
                
    return -1