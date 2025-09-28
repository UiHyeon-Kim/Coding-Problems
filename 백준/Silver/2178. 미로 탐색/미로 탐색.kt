fun main() {
    val (row, col) = readln().split(" ").map { it.toInt() }
    val miro = Array(row) { readln().map { it.digitToInt() } }
    val miroLen = Array(row) { IntArray(col) { -1 } }
    val direction = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun bfs(start: Pair<Int, Int>) {
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(start)
        miroLen[start.first][start.second] = 1

        while (q.isNotEmpty()) {
            val (cx, cy) = q.removeFirst()

            for ((dx, dy) in direction) {
                val nx = cx + dx
                val ny = cy + dy

                if (nx in 0 until row && ny in 0 until col && miro[nx][ny] == 1 && miroLen[nx][ny] == -1) {
                    miroLen[nx][ny] = miroLen[cx][cy] + 1
                    q.add(nx to ny)
                }
            }
        }
    }

    bfs(0 to 0)

    println(miroLen[row - 1][col - 1])
}
