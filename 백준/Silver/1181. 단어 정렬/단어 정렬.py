N = int(input())

words = []
for i in range(N): words.append(input()) # 단어의 개수만큼 리스트에 삽입
words = list(set(words)) # 중복 제거

sorted_words = sorted(words, key= lambda x : (len(x), x)) # 길이를 기준으로 정렬하고, 오름차순(사전순)으로 정렬

# print(sorted_words)
for i in range((len(sorted_words))): 
    
    print(sorted_words[i])