package `7569 토마토`

import java.util.StringTokenizer

class Baekjoon7569 {

    data class Coordinates(val row: Int, val col: Int, val height: Int)

    private val dh = intArrayOf(0, 0, 0, 0, -1, 1)
    private val dr = intArrayOf(-1, 1, 0, 0, 0, 0)
    private val dc = intArrayOf(0, 0, -1, 1, 0, 0)

    fun solve() = with(System.`in`.bufferedReader()) {
        var st = StringTokenizer(readLine())
        val c = st.nextToken().toInt()
        val r = st.nextToken().toInt()
        val h = st.nextToken().toInt()

        val dq = ArrayDeque<Coordinates>()

        var unripeCount = 0

        val box = Array(h) { ch ->
            Array(r) { cr ->
                st = StringTokenizer(readLine())
                IntArray(c) { cc ->
                    val current = st.nextToken().toInt()
                    if (current == 1) dq.add(Coordinates(cr, cc, ch))
                    else if (current == 0) unripeCount++

                    current
                }
            }
        }

        if (unripeCount == 0) {
            println(0)
            return@with
        }

        var days = 0

        while (dq.isNotEmpty()) {
            val (cr, cc, ch) = dq.removeFirst()

            for (i in 0..5) {
                val nr = cr + dr[i]
                val nc = cc + dc[i]
                val nh = ch + dh[i]

                if (nr in 0..<r && nc in 0..<c && nh in 0..<h && box[nh][nr][nc] == 0) {
                    box[nh][nr][nc] = box[ch][cr][cc] + 1
                    dq.add(Coordinates(nr, nc, nh))

                    unripeCount--
                    days = box[nh][nr][nc] - 1
                }
            }
        }

        if (unripeCount > 0) {
            println(-1)
        } else {
            println(days)
        }
    }
}

fun main() {
    Baekjoon7569().solve()
}