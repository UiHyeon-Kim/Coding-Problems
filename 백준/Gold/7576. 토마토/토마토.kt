fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val box = Array(m) { readln().split(" ").map { it.toInt() } }
    val dist = Array(m) { IntArray(n) { -1 } }
    val direction = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun bfs() {
        val totalQ = ArrayDeque<Pair<Int, Int>>()

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (box[i][j] == 1) {
                    totalQ.add(i to j)
                    dist[i][j] = 0
                }
            }
        }

        while (totalQ.isNotEmpty()) {
            val currentQ = ArrayDeque<Pair<Int, Int>>()
            repeat(totalQ.size) { currentQ.add(totalQ.removeFirst()) }
            totalQ.clear()

            while (currentQ.isNotEmpty()) {
                val (cx, cy) = currentQ.removeFirst()

                for ((dx, dy) in direction) {
                    val nx = cx + dx
                    val ny = cy + dy

                    if (nx in 0 until m && ny in 0 until n && box[nx][ny] == 0 && dist[nx][ny] == -1) {
                        totalQ.add(nx to ny)
                        dist[nx][ny] = dist[cx][cy] + 1
                    }
                }
            }
        }
    }

    bfs()

    var result = -1
    result = result.coerceAtLeast(dist.maxOf { it.max() })

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (box[i][j] == 0 && dist[i][j] == -1) result = -1
        }
    }
    println(result)
}
