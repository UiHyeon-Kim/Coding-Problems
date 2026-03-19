import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val t = st.nextToken().toInt()

    var airTop = 0
    var airBottom = 0
    var isFind = false

    var originBoard = Array(r) { cr ->
        st = StringTokenizer(readLine())
        IntArray(c) {
            val current = st.nextToken().toInt()
            if (current == -1 && !isFind) {
                airTop = cr
                airBottom = cr + 1
                isFind = true
            }
            current
        }
    }

    val direction = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun dustSpread(copyBoard: Array<IntArray>) {
        for (i in 0..<r) {
            for (j in 0..<c) {
                if (originBoard[i][j] > 0) {
                    var spreadCount = 0
                    val spreadValue = originBoard[i][j] / 5

                    for ((dr, dc) in direction) {
                        val nr = dr + i
                        val nc = dc + j

                        if (nr in 0..<r && nc in 0..<c && copyBoard[nr][nc] != -1) {
                            copyBoard[nr][nc] += spreadValue
                            spreadCount++
                        }
                    }

                    copyBoard[i][j] += originBoard[i][j] - spreadValue * spreadCount
                }
            }
        }
    }


    fun circulate() {
        for (i in airTop - 1 downTo 1) originBoard[i][0] = originBoard[i - 1][0]
        for (j in 0..<c - 1) originBoard[0][j] = originBoard[0][j + 1]
        for (i in 0..airTop) originBoard[i][c - 1] = originBoard[i + 1][c - 1]
        for (j in c - 1 downTo 2) originBoard[airTop][j] = originBoard[airTop][j - 1]
        originBoard[airTop][1] = 0

        for (i in airBottom + 1 until r - 1) originBoard[i][0] = originBoard[i + 1][0]
        for (j in 0 until c - 1) originBoard[r - 1][j] = originBoard[r - 1][j + 1]
        for (i in r - 1 downTo airBottom + 1) originBoard[i][c - 1] = originBoard[i - 1][c - 1]
        for (j in c - 1 downTo 2) originBoard[airBottom][j] = originBoard[airBottom][j - 1]
        originBoard[airBottom][1] = 0
    }

    repeat(t) {
        val copyBoard = Array(r) { IntArray(c) }

        copyBoard[airTop][0] = -1
        copyBoard[airBottom][0] = -1

        dustSpread(copyBoard)
        
        originBoard = copyBoard
        
        circulate()
    }

    val sum = originBoard.sumOf { it.sum() } + 2
    println(sum)
}
