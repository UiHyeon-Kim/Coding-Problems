data class ShortCut(val start: Int, val end: Int, val weight: Int)

fun main() {
    val (n, d) = readln().split(" ").map { it.toInt() }
    val startBy = Array(d + 1) { mutableListOf<ShortCut>() }

    repeat(n) {
        val (s, e, w) = readln().split(" ").map { it.toInt() }

        if (e > d) return@repeat
        if (s <= d) startBy[s].add(ShortCut(s, e, w))
    }

    val dp = IntArray(d + 1) { Int.MAX_VALUE }
    dp[0] = 0

    for (idx in 0..<d) {
        if (dp[idx] != Int.MAX_VALUE) dp[idx + 1] = minOf(dp[idx + 1], dp[idx] + 1)

        if (dp[idx] != Int.MAX_VALUE) {
            for (sb in startBy[idx]) {
                dp[sb.end] = minOf(dp[sb.end], dp[idx] + sb.weight)
            }
        }
    }

    print(dp[d])
}