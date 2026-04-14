for tc in range(1, 11):
    N = int(input())
    buildings = list(map(int, input().split()))

    result = 0
    for i in range(2, N - 2):
        side_max = max(buildings[i - 2], buildings[i - 1], buildings[i + 1], buildings[i + 2])
        if buildings[i] - side_max > 0:
            result += buildings[i] - side_max

    print(f"#{tc} {result}")