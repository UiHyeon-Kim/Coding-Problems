fun main() {
    val n = readln().toInt()
    val landMineMap = Array(n) { readln().toCharArray() }
    val openInfoMap = Array(n) { readln().toCharArray() }
    val result = Array(n) { CharArray(n) { '.' } }
    val direction = listOf(-1 to -1, -1 to 0, -1 to 1, 0 to -1, 0 to 1, 1 to -1, 1 to 0, 1 to 1)
    var findMine = false

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (openInfoMap[i][j] != 'x') continue
            if (landMineMap[i][j] == '*') findMine = true

            var mineCount = 0

            for ((dx, dy) in direction) {
                val nx = i + dx
                val ny = j + dy

                if (nx !in 0 until n || ny !in 0 until n) continue
                if (landMineMap[nx][ny] == '*') mineCount++
            }

            result[i][j] = mineCount.digitToChar()
        }
    }

    if (findMine) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (landMineMap[i][j] == '*') print('*')
                else print(result[i][j])
            }
            println()
        }
    } else {
        result.forEach { println(it.joinToString("")) }
    }
}
