fun main() {
    val board = Array(5) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val start = readln().split(" ").map { it.toInt() }.let { it.first() to it.last() }

    val direction = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)
    var possible: Boolean

    fun dfs(x: Int, y: Int, move: Int, apple: Int): Boolean {
        if (apple >= 2) return true
        if (move == 3) return false

        val originalBoard = board[x][y]
        board[x][y] = -1

        for ((dx, dy) in direction) {
            val nx = x + dx
            val ny = y + dy

            if (nx !in 0..4 || ny !in 0..4 || board[nx][ny] == -1) continue

            val newApple = if (board[nx][ny] == 1) apple + 1 else apple
            if (dfs(nx, ny, move + 1, newApple)) {
                board[x][y] = originalBoard
                return true
            }
        }
        board[x][y] = originalBoard
        return false
    }

    println(if (dfs(start.first, start.second, 0, 0)) 1 else 0)
}