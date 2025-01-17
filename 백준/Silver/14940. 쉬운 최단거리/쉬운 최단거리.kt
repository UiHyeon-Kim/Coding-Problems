import java.util.*

fun bfs(grid: Array<IntArray>, dist: Array<IntArray>, start: Pair<Int, Int>, n: Int, m: Int): Array<IntArray> {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val direction = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    queue.add(start)
    dist[start.first][start.second] = 0

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for ((dx, dy) in direction) {
            val nx = x + dx
            val ny = y + dy

            if (nx in 0..<n && ny in 0..<m && grid[nx][ny] == 1 && dist[nx][ny] == -1) {
                queue.add(nx to ny)
                dist[nx][ny] = dist[x][y] + 1
            }
        }
    }
    return dist
}

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val grid = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val dist = Array(n) { IntArray(m) }
    var start: Pair<Int, Int>? = null

    for (x in 0..<n) {
        for (y in 0..<m) {
            if (grid[x][y] == 2) start = x to y
            if (grid[x][y] == 1) dist[x][y] = -1 else dist[x][y] = 0
        }
    }

    val result = bfs(grid, dist, start!!, n, m)

    result.forEach { println(it.joinToString(" ")) }
}