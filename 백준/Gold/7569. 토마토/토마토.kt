import java.util.StringTokenizer

data class Coordinates(val row: Int, val col: Int, val height: Int)

class Baekjoon7569 {

    private lateinit var box: Array<Array<IntArray>>
    private lateinit var dq : ArrayDeque<Coordinates>
    private val dh = listOf(0, 0, 0, 0, -1, 1)
    private val dr = listOf(-1, 1, 0, 0, 0, 0)
    private val dc = listOf(0, 0, -1, 1, 0, 0)

    fun solve() = with(System.`in`.bufferedReader()) {
        var st = StringTokenizer(readLine())
        val c = st.nextToken().toInt()
        val r = st.nextToken().toInt()
        val h = st.nextToken().toInt()

        dq = ArrayDeque()

        box = Array(h) { ch ->
            Array(r) { cr ->
                st = StringTokenizer(readLine())
                IntArray(c) { cc ->
                    val current = st.nextToken().toInt()
                    if (current == 1) dq.add(Coordinates(cr, cc, ch))

                    current
                }
            }
        }

        bfs(r, c, h)
        println(getMaxDay(r, c, h))
    }

    private fun bfs(r: Int, c: Int, h: Int) {

        while (dq.isNotEmpty()) {
            val (cr, cc, ch) = dq.removeFirst()

            for (i in 0..5) {
                val nr = cr + dr[i]
                val nc = cc + dc[i]
                val nh = ch + dh[i]

                if (nr in 0..<r && nc in 0..<c && nh in 0..<h && box[nh][nr][nc] == 0) {
                    box[nh][nr][nc] = box[ch][cr][cc] + 1
                    dq.add(Coordinates(nr, nc, nh))
                }
            }
        }
    }

    private fun getMaxDay(r: Int, c: Int, h: Int): Int {
        var max = 0

        for (i in 0..<h) {
            for (j in 0..<r) {
                for (k in 0..<c) {
                    if (box[i][j][k] == 0) return -1
                    if (box[i][j][k] > max) max = box[i][j][k]
                }
            }
        }

        return max - 1
    }
}

fun main() {
    Baekjoon7569().solve()
}