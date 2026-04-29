import heapq


def solve():
    T = int(input())

    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    for tc in range(1, T + 1):
        board_size = int(input())
        board = [list(map(int, input())) for _ in range(board_size)]

        pq = [(0, 0, 0)]  # w, r, c
        dist = [[float('inf')] * board_size for _ in range(board_size)]
        dist[0][0] = 0

        while pq:
            w, r, c = heapq.heappop(pq)

            if dist[r][c] < w:
                continue

            for i in range(4):
                nr = r + dr[i]
                nc = c + dc[i]

                if 0 <= nr < board_size and 0 <= nc < board_size:
                    weight = w + board[nr][nc]
                    if dist[nr][nc] > weight:
                        heapq.heappush(pq, (weight, nr, nc))
                        dist[nr][nc] = weight

        print(f"#{tc} {dist[-1][-1]}")


if __name__ == "__main__":
    solve()
