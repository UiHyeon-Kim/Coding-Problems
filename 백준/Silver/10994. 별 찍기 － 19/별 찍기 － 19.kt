fun main() {
    val n = readln().toInt()
    val size = n * 4 - 3
    val board = Array(size) { Array(size) { " " } }
    var correction = 0

    fun drawStar(i: Int) {
        val maxIndex = i * 4 - 3

        for (j in 0 until maxIndex) {
            board[correction][j + correction] = "*"
            board[j + correction][correction] = "*"
            board[correction + maxIndex - 1][j + correction] = "*"
            board[j + correction][correction + maxIndex - 1] = "*"
        }

        correction += 2
    }


    for (i in n downTo 1 ) {
        drawStar(i)
    }

    board.forEach { println(it.joinToString("")) }
}
