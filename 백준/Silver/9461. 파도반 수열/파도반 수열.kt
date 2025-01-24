fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        println(sequence(n))
    }
}

fun sequence(n: Int): Long {
    val dp = LongArray(101)

    dp[1] = 1
    dp[2] = 1
    dp[3] = 1

    for (i in 4..n) {
        dp[i] = dp[i - 2] + dp[i - 3]
    }

    return dp[n]
}
