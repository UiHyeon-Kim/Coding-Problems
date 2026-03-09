fun main() = with(System.`in`.bufferedReader()) {
    val cardCount = readLine().toInt()
    val cardPrice = listOf(0) + readLine().split(" ").map { it.toInt() }
    val dp = IntArray(cardCount + 1) { Int.MAX_VALUE }

    dp[0] = 0

    for (count in 1..cardCount) {
        for (index in 1..count) {
            dp[count] = minOf(dp[count], dp[count - index] + cardPrice[index])
        }
    }

    println(dp[cardCount])
}