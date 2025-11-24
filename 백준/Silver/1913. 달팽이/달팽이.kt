sealed class Direction {
    data object Top : Direction()
    data object Left : Direction()
    data object Bottom : Direction()
    data object Right : Direction()
}

fun main() {
    val n = readln().toInt()
    val target = readln().toInt()
    val board = Array(n + 1) { IntArray(n + 1) }

    var targetIndex = 0 to 0
    var current = n * n
    var (x, y) = 1 to 1
    var direction: Direction = Direction.Bottom

    while (current != 0) {
        if (current == target) targetIndex = x to y
        board[x][y] = current
        current--

        when (direction) {
            is Direction.Top -> {
                if (x - 1 in 1..n && board[x - 1][y] == 0) {
                    x--
                } else {
                    y--
                    direction = Direction.Left
                }
            }

            is Direction.Left -> {
                if (y - 1 in 1..n && board[x][y - 1] == 0) {
                    y--
                } else {
                    x++
                    direction = Direction.Bottom
                }
            }

            is Direction.Bottom -> {
                if (x + 1 in 1..n && board[x + 1][y] == 0) {
                    x++
                } else {
                    y++
                    direction = Direction.Right
                }
            }

            is Direction.Right -> {
                if (y + 1 in 1..n && board[x][y + 1] == 0) {
                    y++
                } else {
                    x--
                    direction = Direction.Top
                }
            }

            else -> { }
        }

    }

    for (i in 1..n) {
        for (j in 1..n) {
            print("${board[i][j]} ")
        }
        println()
    }
    println("${targetIndex.first} ${targetIndex.second}")
}
