class Baekjoon11055 {
    fun solve() {
        val n = readln().toInt()
        val arr = readln().split(" ").map { it.toInt() }
        val dp = arr.toIntArray()

        for (i in 0 until n) {
            for (j in 0 until i) {
                if (arr[i] > arr[j]) dp[i] = kotlin.math.max(dp[i], dp[j] + arr[i])
            }
        }

        print(dp.maxOrNull())
    }
}

fun main() {
    Baekjoon11055().solve()
}
