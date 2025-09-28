fun main() {
    val (vertical, horizontal) = readln().split(" ").map { it.toInt() }
    val map = Array(vertical) { readln().split(" ").map { it.toInt() } }
    val resultMap = Array(vertical) { IntArray(horizontal) { -1 } }
    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)
    var start = 0 to 0

    for (i in 0..<vertical) {
        for (j in 0..<horizontal) {
            if (map[i][j] == 2) start = i to j
            if (map[i][j] != 1) resultMap[i][j] = 0
        }
    }

    fun bfs(start: Pair<Int, Int>) {
        val q = ArrayDeque<Pair<Int, Int>>()

        q.add(start)

        while (q.isNotEmpty()) {
            val (cx, cy) = q.removeFirst()

            for (i in 0..<4) {
                val nx = cx + dx[i]
                val ny = cy + dy[i]

                if (nx in 0..<vertical && ny in 0..<horizontal && map[nx][ny] == 1 && resultMap[nx][ny] == -1) {
                    q.add(nx to ny)
                    resultMap[nx][ny] = resultMap[cx][cy] + 1
                }
            }
        }
    }

    bfs(start)

    resultMap.forEach { row ->
        println(row.joinToString(" "))
    }
}
