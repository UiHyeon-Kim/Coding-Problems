fun main() {
    val n = readln().toInt()
    val dp = Array(n + 1) { 0 }

    dp[1] = 1
    if (n >= 2) dp[2] = 2

    for (i in 3..n) {
        dp[i] = (dp[i - 2] + dp[i - 1]) % 10007
    }

    println(dp[n])
}
