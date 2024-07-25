# 2470
# 두 용액

N = int(input())
water = list(map(int, input().split(' ')))

water.sort() # 오름차순으로 정렬
left = 0 # 왼쪽 포인터
right = N - 1 # 오른쪽 포인터

output = [water[left], water[right]] # 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값
while left < right:

    if abs(water[left] + water[right]) < abs(output[0] + output[1]): # 현재 결과값보다 더 0에 가까운 두 용액의 특성값 합을 찾았다면
        output = [water[left], water[right]] # 결과값을 업데이트

    if water[left] + water[right] < 0: # 합이 0보다 작으면 특성값의 합을 키워야 하므로
        left += 1 # 왼쪽 포인터를 오른쪽으로 한 칸 이동
    elif water[left] + water[right] > 0: # 합이 0보다 크면 특성값의 합을 줄여야 하므로
        right -= 1 # 오른쪽 포인터를 왼쪽으로 한 칸 이동
    else: # 합이 0이라면 이미 특성값이 0에 가장 가까운 용액을 찾은 것이므로
        output = [water[left], water[right]] # 결과값을 업데이트하고 종료
        break

print(*(output))