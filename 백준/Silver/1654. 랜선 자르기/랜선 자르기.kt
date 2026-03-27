import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val k = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val cables = IntArray(k) { readLine().toInt() }

    var left = 1L
    var right = cables.maxOrNull()?.toLong() ?: 0L
    var maxLen = 0L

    while (left <= right) {
        val mid = (left + right) / 2L
        var count = 0L

        for (cable in cables) {
            count += (cable / mid)
        }

        if (count >= n) {
            maxLen = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(maxLen)
}