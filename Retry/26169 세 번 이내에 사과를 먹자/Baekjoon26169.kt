class Baekjoon26169 {

    private lateinit var board: Array<IntArray>

    fun solve() {
        board = Array(SIZE) { readln().split(" ").map { it.toInt() }.toIntArray() }
        val (startRow, startCol) = readln().split(" ").map { it.toInt() }

        println(if (dfs(startRow, startCol, 0, 0)) 1 else 0)
    }

    private fun dfs(row: Int, col: Int, apple: Int, move: Int): Boolean {
        if (apple >= 2) return true
        if (move == 3) return false

        val originalValue = board[row][col]
        board[row][col] = WALL

        for ((dr, dc) in direction) {
            val nr = row + dr
            val nc = col + dc

            if (nr !in 0 until SIZE || nc !in 0 until SIZE) continue
            if (board[nr][nc] == WALL) continue

            val newApple = if (board[nr][nc] == 1) apple + 1 else apple
            if (dfs(nr, nc, newApple, move + 1)) {
                board[row][col] = originalValue
                return true
            }
        }

        board[row][col] = originalValue
        return false
    }

    companion object {
        private val direction = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

        const val SIZE = 5
        const val WALL = -1
    }
}

fun main() {
    Baekjoon26169().solve()
}
