class Baekjoon20922 {

    private lateinit var number: IntArray
    private lateinit var numberCount: IntArray

    fun solve() = with(System.`in`.bufferedReader()) {
        val (length, maxCount) = readLine().split(" ").map { it.toInt() }
        number = readLine().split(" ").map { it.toInt() }.toIntArray()
        numberCount = IntArray(100_001)

        val max = getMaxLength(length, maxCount)
        println(max)
    }

    private fun getMaxLength(length: Int, maxCount: Int): Int {
        var left = 0
        var max = 0

        for (right in 0 until length) {
            numberCount[number[right]]++

            while (numberCount[number[right]] > maxCount) {
                numberCount[number[left++]]--
            }
            max = max.coerceAtLeast(right - left + 1)
        }

        return max
    }
}

fun main() {
    Baekjoon20922().solve()
}