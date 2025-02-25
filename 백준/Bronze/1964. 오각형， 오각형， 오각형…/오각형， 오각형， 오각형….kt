fun main() {
    val n = readln().toInt()
    val dp = LongArray(n + 1)

    dp[1] = 5

    for (i in 2..n) {
        dp[i] = (dp[i - 1] + 3 * i + 1) % 45678
    }

    println(dp[n])
}
