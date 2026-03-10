fun main() = with(System.`in`.bufferedReader()) {
    val case = readLine().toInt()
    val direction = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    repeat(case) {
        val (col, row, count) = readLine().split(' ').map { it.toInt() }
        val field = Array(col) { BooleanArray(row) }

        repeat(count) {
            val (x, y) = readLine().split(' ').map { it.toInt() }
            field[x][y] = true
        }

        fun dfs(x: Int, y: Int) {
            if (!field[x][y]) return
            field[x][y] = false

            for ((dx, dy) in direction) {
                val (nx, ny) = x + dx to y + dy

                if (nx in 0..<col && ny in 0..<row) {
                    if (field[nx][ny]) {
                        dfs(nx, ny)
                    }
                }
            }
        }

        var sum = 0

        for (i in 0..<col) {
            for (j in 0..<row) {
                if (field[i][j]) {
                    dfs(i, j)
                    sum++
                }
            }
        }

        println(sum)
    }
}