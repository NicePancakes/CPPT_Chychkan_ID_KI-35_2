n = int(input("Введіть розмір квадратної матриці: "))
filler = input("\nВведіть символ-заповнювач: ")

if len(filler) != 1:
    print("\nНе коректний символ заповнювач")
    raise SystemExit

average_n = -(-n // 2)
arr = []

if n % 2 == 0:
    for i in range(n):
        if i <= average_n:
            if i == average_n:
                arr.append(filler * i)
            else:
                arr.append(filler * (i + 1))
        else:
            arr.append(filler * (n - i))

else:
    for i in range(n):
        if i < average_n:
            arr.append(filler * (i + 1))
        else:
            arr.append(filler * (n - i))

for i in range(n):
    for j in range(len(arr[i])):
        print(arr[i][j], end=" ")
    print()
