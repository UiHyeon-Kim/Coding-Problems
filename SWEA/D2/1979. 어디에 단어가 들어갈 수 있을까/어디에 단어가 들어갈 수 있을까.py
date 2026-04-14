T = int(input())
for tc in range(1, T + 1):
    N, K = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)]

    result = 0

    for row in arr:
        lines = "".join(map(str, row)).split("0")
        for line in lines:
            if len(line) == K:
                result += 1

    for row in zip(*arr):
        lines = "".join(map(str, row)).split("0")
        for line in lines:
            if len(line) == K:
                result += 1


    print(f"#{tc} {result}")