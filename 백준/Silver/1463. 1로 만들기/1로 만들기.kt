fun main() {
    val n = readln().toInt()
    val dp = IntArray(n + 1) { Int.MAX_VALUE }

    dp[1] = 0
    if (n >= 2) dp[2] = 1
    if (n >= 3) dp[3] = 1

    for (i in 4..n) {
        if (i % 2 == 0 && i % 3 == 0) dp[i] = minOf(dp[i - 1], dp[i / 2], dp[i / 3]) + 1
        else if (i % 2 == 0) dp[i] = minOf(dp[i - 1], dp[i / 2]) + 1
        else if (i % 3 == 0) dp[i] = minOf(dp[i - 1], dp[i / 3]) + 1
        else dp[i] = dp[i - 1] + 1
    }

    println(dp[n])
}