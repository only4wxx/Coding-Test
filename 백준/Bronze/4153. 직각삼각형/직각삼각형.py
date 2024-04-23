while True:
    length_list = input().split()
    if length_list[0] != '0':
        # print(length_list)
        val1 = int(length_list[0]) ** 2
        val2 = int(length_list[1]) ** 2
        val3 = int(length_list[2]) ** 2

        if val1 == val2 + val3 or val2 == val1 + val3 or val3 == val1 + val2: # 직각 삼각형이 맞으면
            print("right")
        else: print("wrong")
    else:
        break