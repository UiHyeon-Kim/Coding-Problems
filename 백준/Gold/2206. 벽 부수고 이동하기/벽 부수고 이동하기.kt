import java.util.StringTokenizer

private val dr = intArrayOf(-1, 1, 0, 0)
private val dc = intArrayOf(0, 0, -1, 1)

data class Info(val r: Int, val c: Int, val dist: Int, val broken: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    val miro = Array(r) {
        val s = readLine()
        IntArray(c) { i -> s[i].digitToInt() }
    }

    val visited = Array(2) { Array(r) { BooleanArray(c) } }
    val q = ArrayDeque<Info>()

    q.add(Info(0, 0, 1, 0))
    visited[0][0][0] = true

    while (q.isNotEmpty()) {
        val current = q.removeFirst()

        if (current.r == r - 1 && current.c == c - 1) {
            println(current.dist)
            return@with
        }

        for (i in 0..3) {
            val nr = current.r + dr[i]
            val nc = current.c + dc[i]

            if (nr in 0..<r && nc in 0..<c) {
                if (miro[nr][nc] == 0 && !visited[current.broken][nr][nc]) {
                    visited[current.broken][nr][nc] = true
                    q.add(Info(nr, nc, current.dist + 1, current.broken))

                } else if (miro[nr][nc] == 1 && current.broken == 0) {
                    visited[1][nr][nc] = true
                    q.add(Info(nr, nc, current.dist + 1, 1))
                }
            }
        }
    }

    println(-1)
}