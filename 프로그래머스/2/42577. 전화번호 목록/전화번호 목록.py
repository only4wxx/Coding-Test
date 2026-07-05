def solution(phone_book):
    answer = True
    
    dict = {}
    # 일단 dict에 다 넣음
    for number in phone_book:
        dict[number] = 1
    
    # 본인 빼고 접두어 비교
    for number in phone_book:
        temp = ""
        for char in number[:-1]:
            temp += char
            if temp in dict:
                return False
    
    return answer