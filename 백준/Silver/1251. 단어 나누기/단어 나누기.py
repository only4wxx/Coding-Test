word = input()

word_list = []
for i in range(1, len(word)-1):
    for j in range(i+1, len(word)):
        word_list.append("".join(reversed(word[0:i]))+"".join(reversed(word[i:j]))+"".join(reversed(word[j:len(word)])))

# print(word_list)
print(min(word_list))