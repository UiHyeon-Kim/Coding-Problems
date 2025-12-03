fun main() {
    val (rowSize, colSize) = readln().split(" ").map { it.toInt() }
    val emptyIndex = mutableListOf<Pair<Int, Int>>() // 벽을 세울 수 있는 빈 공간 인덱스
    val board = Array(rowSize) { row ->
        readln().split(" ").map { it.toInt() }.toIntArray().also {
            it.forEachIndexed { col, value -> if (value == 0) emptyIndex.add(row to col) }
        }
    }

    val direction = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    var max = 0

    // 보드 감염 및 감염 후 0개수 반환
    fun infection(): Int {
        val currentBoard = Array(rowSize) { board[it].clone() }
        val q = ArrayDeque<Pair<Int, Int>>()

        for (i in 0 until rowSize) {
            for (j in 0 until colSize) {
                if (currentBoard[i][j] == 2) q.add(i to j)
            }
        }

        while (q.isNotEmpty()) {
            val (cr, cc) = q.removeFirst()

            for ((dr, dc) in direction) {
                val nr = cr + dr
                val nc = cc + dc

                if (nr !in 0 until rowSize || nc !in 0 until colSize) continue
                if (currentBoard[nr][nc] == 0) {
                    currentBoard[nr][nc] = 2
                    q.add(nr to nc)
                }
            }
        }

        return currentBoard.sumOf { it.count { value -> value == 0 } }
    }

    fun backtrack(start: Int, wall: Int) {
        if (wall == 3) {
            max = max.coerceAtLeast(infection())
            return
        }

        for (i in start until emptyIndex.size) {
            val (r, c) = emptyIndex[i]
            board[r][c] = 1
            backtrack(i + 1, wall + 1)
            board[r][c] = 0
        }
    }

    backtrack(0, 0)
    println(max)
}