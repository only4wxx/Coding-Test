def solution(participant, completion):
    answer = ''
    
    dict = {} # 해당 이름을 가진 참가자 수
    for p in participant:
        if p in dict:
            dict[p] += 1
        else:
            dict[p] = 1
    
    for c in completion:
        if dict[c] > 1:
            dict[c] -= 1
        else:
            del dict[c]
    
    answer = list(dict.keys())[0]
    
    return answer