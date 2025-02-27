fun main() {
    val n = readln().toInt()
    val turningBoard = readln()
    val m = readln().toInt()
    val str = readln()
    var result = StringBuilder()

    if (str.any { it !in turningBoard }) {
        println(-1)
        return
    }

    var boardIndex = n
    var strIndex = 0
    var count = 0
    while (result.toString() != str) {
        count++
        boardIndex++
        if (boardIndex >= n) boardIndex = 0

        if (str[strIndex] == turningBoard[boardIndex]) {
            result.append(turningBoard[boardIndex])
            strIndex++
        }
    }

    println(count)
}
