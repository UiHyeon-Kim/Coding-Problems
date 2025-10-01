fun main() {
    val (n, m, time) = readln().split(" ").map { it.toInt() }
    val castle = Array(n) { readln().split(" ").map { it.toInt() } }
    val dist = Array(n) { IntArray(m) { -1 } }
    val direction = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    var gramIdx = 0 to 0

    fun bfs(start: Pair<Int, Int>) {
        val q = ArrayDeque<Pair<Int, Int>>()

        q.add(start)
        dist[start.first][start.second] = 0

        while (q.isNotEmpty()) {
            val (cx, cy) = q.removeFirst()

            for ((dx, dy) in direction) {
                val nx = cx + dx
                val ny = cy + dy

                if (nx in 0 until n && ny in 0 until m && castle[nx][ny] != 1 && dist[nx][ny] == -1) {
                    q.add(nx to ny)
                    dist[nx][ny] = dist[cx][cy] + 1

                    if (castle[nx][ny] == 2) gramIdx = nx to ny
                }
            }
        }
    }

    bfs(0 to 0)

    val originLen = if (dist[n - 1][m - 1] != -1) dist[n - 1][m - 1] else Int.MAX_VALUE
    val gramLen = if (gramIdx != 0 to 0) dist[gramIdx.first][gramIdx.second] + (n - 1) - gramIdx.first + (m - 1) - gramIdx.second else Int.MAX_VALUE
    val result = originLen.coerceAtMost(gramLen)

    println(if (result > time) "Fail" else result)
}
