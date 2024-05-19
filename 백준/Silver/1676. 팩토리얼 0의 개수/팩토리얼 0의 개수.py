N = int(input())

number = 1
for n in range(1, N+1):
    number *= n

number = str(number)
zero = 0
for i in range(len(number)-1, -1, -1):
    if number[i] == '0': 
        zero += 1
    else:
        break

print(zero)