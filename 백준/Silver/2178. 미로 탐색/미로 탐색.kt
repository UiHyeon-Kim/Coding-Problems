import java.util.StringTokenizer

class Baekjoon2178 {

    private lateinit var miro: Array<IntArray>
    private var r = 0
    private var c = 0

    fun solve() = with(System.`in`.bufferedReader()) {
        val st = StringTokenizer(readLine())
        r = st.nextToken().toInt()
        c = st.nextToken().toInt()

        miro = Array(r) {
            val row = readLine()

            IntArray(c) { i ->
                row[i].digitToInt()
            }
        }

        println(bfs())
    }

    private fun bfs(): Int {
        val dr = listOf(-1, 1, 0, 0)
        val dc = listOf(0, 0, -1, 1)

        val q = ArrayDeque<Pair<Int, Int>>()
        val visited = Array(r) { IntArray(c) { -1 } }

        q.add(0 to 0)
        visited[0][0] = 1

        while (q.isNotEmpty()) {
            val (cr, cc) = q.removeFirst()

            for (i in 0..<4) {
                val nr = cr + dr[i]
                val nc = cc + dc[i]

                if (nr in 0..<r && nc in 0..<c && miro[nr][nc] == 1 && visited[nr][nc] == -1) {
                    q.add(nr to nc)
                    visited[nr][nc] = visited[cr][cc] + 1
                }
            }
        }

        return visited[r - 1][c - 1]
    }
}

fun main() {
    Baekjoon2178().solve()
}