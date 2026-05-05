T = int(input())

def dfs(idx, result):
    if result > K:
        return

    global ans
    if idx == N:
        if result == K:
            ans += 1
        return


    dfs(idx + 1, result)
    dfs(idx + 1, result + arr[idx])


for tc in range(1, T + 1):
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    ans = 0

    dfs(0, 0)

    print(f"#{tc} {ans}")