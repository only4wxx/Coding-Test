def solution(brown, yellow):
    answer = []
    
    b_sum = brown - 4 # 꼭짓점 네개 빼기
    divisors = get_divisors(yellow)
    for divisor in divisors:
        d1 = divisor[0]
        d2 = divisor[1]
        if b_sum == d1*2 + d2*2:
            answer = [d2+2, d1+2] # 가로가 더 기니까
    
    return answer

def get_divisors(num): # 수의 약수 조합 구하기
    divisors = []
    
    n = int(num ** 0.5)
    for d1 in range(1, n+1):
        if num % d1 == 0: # 나누어 떨어지면
            d2 = num // d1
            divisors.append([d1, d2])
    return divisors