for tc in range(1, 11):
    dump = int(input())
    arr = list(map(int, input().split()))

    for i in range(dump):
        min_idx = arr.index(min(arr))
        max_idx = arr.index(max(arr))
        arr[min_idx] += 1
        arr[max_idx] -= 1

    print(f"#{tc} {max(arr) - min(arr)}")
    