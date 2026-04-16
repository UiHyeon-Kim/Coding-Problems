side = [-1, 1]

for _ in range(10):
    tc = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    cx = -1
    cy = 99

    for x in range(100):
        if arr[cy][x] == 2:
            cx = x
            break

    while cy > 0:
        if 0 <= cx + 1 < 100 and arr[cy][cx + 1] == 1:
            while 0 <= cx + 1 < 100 and arr[cy][cx + 1] == 1:
                cx += 1
        elif 0 <= cx - 1 < 100 and arr[cy][cx - 1] == 1:
            while 0 <= cx - 1 < 100 and arr[cy][cx - 1] == 1:
                cx -= 1
        cy -= 1

    print(f"#{tc} {cx}")