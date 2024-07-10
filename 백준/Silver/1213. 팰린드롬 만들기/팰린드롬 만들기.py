# 1213
# 팰린드롬 만들기

from collections import deque

name = list(input()) # 영어 이름을 입력받음
name.sort() # 사전순으로 정렬

def palindrome(name):

    # 팰린드롬 문자열을 만들 수 있는지를 판별
    alphabet = [] # 현재 있는 알파벳
    middle = '' # 중간에 올 알파벳
    i = 0 # 현재 체크하고 있는 알파벳의 위치
    while i < len(name):
        if i < len(name)-1 and name[i] == name[i+1]: # 해당 알파벳이 두개씩 있다면
            alphabet.append(name[i])
            i += 2
        else: # 해당 알파벳이 하나만 있다면
            if middle: # 중간에 올 알파벳이 이미 있었다면
                print("I'm Sorry Hansoo") # 팰린드롬 문자열 불가능
                return
            else: middle = name[i] # 중간에 오도록 배치
            i += 1
    
    # 팰린드롬 문자열로 만들기
    alphabet.sort(reverse=True) # 문자열을 사전순 반대로 정렬
    result = deque([middle])
    for alpha in alphabet:
        result.appendleft(alpha)
        result.append(alpha)
    print(''.join(result))

palindrome(name)