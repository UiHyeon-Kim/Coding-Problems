def union(a, b):
    r1 = find(a)
    r2 = find(b)

    if r1 != r2:
        parents[r2] = r1

def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]

def solve():
    global parents

    T = int(input())

    for tc in range(1, T + 1):
        N, M = map(int, input().split())
        arr = list(map(int, input().split()))
        parents = list(range(N + 1))

        for i in range(0, len(arr), 2):
            union(arr[i], arr[i + 1])

        result = 0
        for i in range(1, N + 1):
            if parents[i] == i:
                result += 1

        print(f"#{tc} {result}")


if __name__ == "__main__":
    solve()