# 22251
# 빌런 호석

# 바꿀 층수는 N 이하여야 함, 층 자리수 K
# LED 중 최소 1개 최대 P개 반전, 실제 층은 X층
N, K, P, X = map(int, input().split(' '))

LED = [ # 각 숫자에서 불이 들어오는 칸의 위치
    set([0, 1, 2, 4, 5, 6]),
    set([2, 5]),
    set([0, 2, 3, 4, 6]),
    set([0, 2, 3, 5, 6]),
    set([1, 2, 3, 5]),
    set([0, 1, 3, 5, 6]),
    set([0, 1, 3, 4, 5, 6]),
    set([0, 2, 5]),
    set([0, 1, 2, 3, 4, 5, 6]),
    set([0, 1, 2, 3, 5, 6])
]

output = 0 # LED를 올바르게 반전시킬 수 있는 경우의 수
before = [0 for _ in range(K-len(str(X)))] # 실제 층
before += map(int, list(str(X)))
for n in range(1, N+1): # 최대값까지
    after = [0 for _ in range(K-len(str(n)))] # 실제 층
    after += map(int, list(str(n)))

    num_reverse = 0 # 반전시킨 LED의 수
    for i in range(K): num_reverse += len(LED[before[i]] ^ LED[after[i]])
    if num_reverse <= P: output += 1

print(output-1) # 실제 층도 체크되었으므로 1을 빼줌