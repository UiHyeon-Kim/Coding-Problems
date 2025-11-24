fun main() {
    val coordinate = HashMap<Int, Pair<Int, Int>>() // 값 to 좌표

    for (i in 0 until 5) {
        val nums = readln().split(" ").map { it.toInt() }

        for ((j, num) in nums.withIndex()) {
            coordinate[num] = i to j
        }
    }

    val rowCount = IntArray(5)
    val colCount = IntArray(5)
    var rightBottom = 0
    var rightTop = 0

    var bingo = 0
    var call = 0

    repeat(5) {
        val nums = readln().split(" ").map { it.toInt() }

        for (num in nums) {
            call++

            val (row, col) = coordinate[num]!!

            if (++rowCount[row] == 5) bingo++
            if (++colCount[col] == 5) bingo++
            if (row == col && ++rightBottom == 5) bingo++
            if (row + col == 4 && ++rightTop == 5) bingo++

            if (bingo >= 3) {
                println(call)
                return
            }
        }
    }
}
