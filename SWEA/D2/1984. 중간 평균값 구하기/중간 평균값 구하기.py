T = int(input())

for i in range(1, T + 1):
    arr = list(map(int, input().split()))
    arr.sort()
    avg = round(sum([arr[j] for j in range(1, len(arr) - 1)]) / 8)
    print(f"#{i} {avg}")