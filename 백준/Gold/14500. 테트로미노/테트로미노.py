# 14500
# 테트로미노

N, M = map(int, input().split(' '))
paper = []
for _ in range(N): paper.append(list(map(int, input().split(' '))))
# print(paper)

max_num = 0
for n in range(N):
    for m in range(M):

        # 1번 테트로미노
        if m+3 < M:
            num = paper[n][m] + paper[n][m+1] + paper[n][m+2] + paper[n][m+3]
            if num > max_num: max_num = num
        if n+3 < N:
            num = paper[n][m] + paper[n+1][m] + paper[n+2][m] + paper[n+3][m]
            if num > max_num: max_num = num

        # 2번 테트로미노
        if n+1 < N and m+1 < M:
            num = paper[n][m] + paper[n][m+1] + paper[n+1][m] + paper[n+1][m+1]
            if num > max_num: max_num = num

        # 3번 테트로미노
        if n+2 < N:
            if m+1 < M:
                num = paper[n][m] + paper[n+1][m] + paper[n+2][m] + paper[n][m+1]
                if num > max_num: max_num = num

                num = paper[n][m] + paper[n+1][m] + paper[n+2][m] + paper[n+2][m+1]
                if num > max_num: max_num = num
            if m-1 > -1:
                num = paper[n][m] + paper[n+1][m] + paper[n+2][m] + paper[n][m-1]
                if num > max_num: max_num = num

                num = paper[n][m] + paper[n+1][m] + paper[n+2][m] + paper[n+2][m-1]
                if num > max_num: max_num = num
        if m+2 < M:
            if n+1 < N:
                num = paper[n][m] + paper[n][m+1] + paper[n][m+2] + paper[n+1][m]
                if num > max_num: max_num = num

                num = paper[n][m] + paper[n][m+1] + paper[n][m+2] + paper[n+1][m+2]
                if num > max_num: max_num = num
            if n-1 > -1:
                num = paper[n][m] + paper[n][m+1] + paper[n][m+2] + paper[n-1][m]
                if num > max_num: max_num = num

                num = paper[n][m] + paper[n][m+1] + paper[n][m+2] + paper[n-1][m+2]
                if num > max_num: max_num = num
        
        # 4번 테트로미노
        if n+2 < N and m+1 < M:
            num = paper[n][m] + paper[n+1][m] + paper[n+1][m+1] + paper[n+2][m+1]
            if num > max_num: max_num = num

            num = paper[n][m+1] + paper[n+1][m] + paper[n+1][m+1] + paper[n+2][m]
            if num > max_num: max_num = num
        if n+1 < N and m+2 < M:
            num = paper[n][m+1] + paper[n][m+2] + paper[n+1][m] + paper[n+1][m+1]
            if num > max_num: max_num = num

            num = paper[n][m] + paper[n][m+1] + paper[n+1][m+1] + paper[n+1][m+2]
            if num > max_num: max_num = num
        
        # 5번 테트로미노
        if n+1 < N and m+2 < M:
            num = paper[n][m] + paper[n][m+1] + paper[n][m+2] + paper[n+1][m+1]
            if num > max_num: max_num = num

            num = paper[n+1][m] + paper[n+1][m+1] + paper[n+1][m+2] + paper[n][m+1]
            if num > max_num: max_num = num
        if n+2 < N and m+1 < M:
            num = paper[n][m] + paper[n+1][m] + paper[n+2][m] + paper[n+1][m+1]
            if num > max_num: max_num = num

            num = paper[n][m+1] + paper[n+1][m+1] + paper[n+2][m+1] + paper[n+1][m]
            if num > max_num: max_num = num

print(max_num)