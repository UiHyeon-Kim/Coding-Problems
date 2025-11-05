class Baekjoon11053 {
    fun solve() {
        val n = readln().toInt()
        val arr = readln().split(" ").map { it.toInt() }
        val dp = IntArray(n) { 1 } // 횟수

        for (i in 1 until n) {
            for (j in 0 until i) {
                if (arr[i] > arr[j]) dp[i] = kotlin.math.max(dp[i], dp[j] + 1)
            }
        }

        println(dp.max())
    }
}

fun main() {
    Baekjoon11053().solve()
}
