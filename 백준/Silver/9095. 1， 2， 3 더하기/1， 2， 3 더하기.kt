fun main() {
    val t = readln().toInt()

    repeat(t) {
        val num = readln().toInt()
        println(methodCounts(num))
    }
}

fun methodCounts(num: Int): Int {
    val dp = Array(12) { 0 }

    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4..num) {
        dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]
    }

    return dp[num]
}
