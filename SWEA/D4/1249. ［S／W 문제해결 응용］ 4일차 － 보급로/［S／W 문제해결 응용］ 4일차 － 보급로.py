import heapq

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input())) for _ in range(N)]
    dist = [[float('inf')] * N for _ in range(N)]
    dist[0][0] = 0
    pq = [(0, 0, 0)]


    while pq:
        w, r, c = heapq.heappop(pq)

        if w > dist[r][c]:
            continue

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            if 0 <= nr < N and 0 <= nc < N:
                cost = w + arr[nr][nc]
                if cost < dist[nr][nc]:
                    dist[nr][nc] = cost
                    heapq.heappush(pq, (cost, nr, nc))

    print(f"#{tc} {dist[N - 1][N - 1]}")
