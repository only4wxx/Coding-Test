# 12865
# 평범한 배낭

N, K = map(int, input().split(' ')) # 물품의 수 N, 버틸 수 있는 무게 K
objects = [list(map(int, input().split(' '))) for _ in range(N)]
dp = [[0]*(K+1) for _ in range(N+1)] # dp는 0~K+1, 0~N+1로 구성

for i in range(1, N+1): # 1~N
    for j in range(K+1): # 0~K
        if objects[i-1][0] <= j: # 해당 물건을 담을 수 있는 배낭들
            dp[i][j] = max(dp[i-1][j], objects[i-1][1]+dp[i-1][j-objects[i-1][0]]) # 원래 값과, 현재 물건의 값+이전 물건의 값 중 최대값을 저장
        else: # 해당 물건을 담을 수 없는 배낭들
            dp[i][j] = dp[i-1][j] # 값이 동일
print(dp[N][K]) # 배낭에 넣을 수 있는 물건들의 가치합의 최댓값