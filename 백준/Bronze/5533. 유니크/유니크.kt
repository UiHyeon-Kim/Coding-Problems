fun main() {
    val n = readln().toInt()
    val inputScore = Array(n) {IntArray(3) }
    val numbers = Array(3) { IntArray(101) }

    repeat(n) {
        val (o, tw, th) = readln().split(" ").map { it.toInt() }
        numbers[0][o]++
        numbers[1][tw]++
        numbers[2][th]++

        inputScore[it][0] = o
        inputScore[it][1] = tw
        inputScore[it][2] = th
    }

    repeat(n) { i ->
        var score = 0

        for (v in 0..<3) {
            val num = inputScore[i][v]
            if (numbers[v][num] == 1) score += num
        }

        println(score)
    }
}
