import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    private static class Loc implements Comparable<Loc> {
        int row, col, wei;

        Loc(int row, int col, int wei) {
            this.row = row;
            this.col = col;
            this.wei = wei;
        }

        @Override
        public int compareTo(Loc other) {
            return Integer.compare(wei, other.wei);
        }
    }

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) {
                char[] raw = br.readLine().toCharArray();

                for (int j = 0; j < N; j++) {
                    board[i][j] = raw[j] - '0';
                }
            }

            PriorityQueue<Loc> pq = new PriorityQueue<>();
            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            pq.add(new Loc(0, 0, 0));
            dist[0][0] = 0;

            while (!pq.isEmpty()) {
                Loc loc = pq.poll();

                int r = loc.row;
                int c = loc.col;
                int w = loc.wei;

                if (w > dist[r][c]) continue;

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (0 > nr || nr >= N || 0 > nc || nc >= N) continue;

                    int cost = w + board[nr][nc];
                    if (cost < dist[nr][nc]) {
                        dist[nr][nc] = cost;
                        pq.offer(new Loc(nr, nc, cost));
                    }
                }
            }

            sb.append('#')
                    .append(tc)
                    .append(' ')
                    .append(dist[N - 1][N - 1])
                    .append('\n');
        }
        System.out.print(sb);
    }
}