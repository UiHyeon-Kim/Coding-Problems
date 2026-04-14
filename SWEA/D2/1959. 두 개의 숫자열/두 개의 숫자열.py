T = int(input())
for tc in range(1, T + 1):
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))
    brr = list(map(int, input().split()))

    diff_size = N - M

    if N < M:
        arr, brr = brr[:], arr[:]
        diff_size = M - N
        M = N

    max_val = 0

    for i in range(diff_size + 1):
        sum_val = 0

        tmp = arr[i : i + M]
        for j in range(M):
            sum_val += tmp[j] * brr[j]

        if max_val < sum_val:
            max_val = sum_val

    print(f"#{tc} {max_val}")