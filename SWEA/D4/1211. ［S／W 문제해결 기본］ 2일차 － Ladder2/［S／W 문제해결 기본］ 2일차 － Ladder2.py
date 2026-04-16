def get_dist(sx, board) -> int:
    cx, cy = sx, 0
    dist = 0

    while cy < 99:
        if cx - 1 >= 0 and board[cy][cx - 1] == 1:
            while cx - 1 >= 0 and board[cy][cx - 1] == 1:
                cx -= 1
                dist += 1
        elif cx + 1 < 100 and board[cy][cx + 1] == 1:
            while cx + 1 < 100 and board[cy][cx + 1] == 1:
                cx += 1
                dist += 1
        cy += 1
        dist += 1
    return dist


for _ in range(10):
    tc = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    starts = [idx for idx, val in enumerate(arr[0]) if val == 1]

    min_dist = float('inf')
    result = -1

    for sx in starts:
        current = get_dist(sx, arr)

        if current <= min_dist:
            min_dist = current
            result = sx

    print(f"#{tc} {result}")
