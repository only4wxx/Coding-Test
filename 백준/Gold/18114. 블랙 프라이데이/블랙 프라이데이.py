# 18114
# 블랙 프라이데이

N, C = map(int, input().split()) # 물건의 개수 N, 제시하는 무게 C

weight = list(map(int, input().split()))
weight.sort() # 오름차순으로 정렬

def find_combination(N, C):
    max_index = N - 1 # 제시하는 무게보다 가벼운 최대 무게
    while max_index > 0 and weight[max_index] > C: max_index -= 1

    # 물건 하나로 조합을 만족하는 경우
    if weight[max_index] == C: return 1
    
    # 물건 여러 개로 조합을 만족하는 경우
    left = 0
    right = max_index
    while left < right:
        diff = C - (weight[left] + weight[right]) # 물건 두 개 무게의 합이 제시된 무게보다 얼마나 부족한지
        if weight[left] + weight[right] == C: return 1 # 두 물건 무게의 합이 C이면 조합을 찾은 것이므로 종료
        elif weight[left] + weight[right] > C: # 두 물건 무게의 합이 제시된 무게보다 크다면
            right -= 1 # 무게의 합을 줄여야 하므로 오른쪽 포인터를 한 칸 왼쪽으로 이동
        else: # 두 물건 무게의 합이 제시된 무게보다 작다면
            if diff in weight[left+1:right]: return 1 # 제시된 무게에서 부족한 값이 두 포인터가 가리키는 물건 사이에 있다면 종료
            left += 1 # 무게의 합을 키워야 하므로 왼쪽 포인터를 한 칸 오른쪽으로 이동

    return 0 # 조합을 찾지 못함

print(find_combination(N, C))