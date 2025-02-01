fun main() {
    val n = readln().toInt()
    val map = Array(n) { readln().map { it - '0' }.toIntArray() }
    val visited = Array(n) { BooleanArray(n) }
    val direction = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    val result = mutableListOf<Int>()

    fun dfs(x: Int, y: Int): Int {
        visited[x][y] = true
        var size = 1

        for ((dx, dy) in direction) {
            val nx = x + dx
            val ny = y + dy

            if (nx in 0..<n && ny in 0..<n && !visited[nx][ny] && map[nx][ny] == 1) {
                size += dfs(nx, ny)
            }
        }
        return size
    }

    for (i in 0..<n) {
        for (j in 0..<n) {
            if (map[i][j] == 1 && !visited[i][j]) {
                result.add(dfs(i, j))
            }
        }
    }

    println(result.size)
    result.sorted().forEach { println(it) }
}
