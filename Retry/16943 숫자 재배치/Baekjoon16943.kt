class Baekjoon16943 {

    private lateinit var num: List<Char>

    fun solve() {
        val (input, upperLimit) = readln().split(" ")

        num = input.toCharArray().sortedDescending()

        val max = findMaxValue(upperLimit.toInt())

        println(max)
    }

    private fun findMaxValue(maxValue: Int): Int {
        val length = num.size
        val visited = BooleanArray(length)
        var max = -1

        fun backtrack(str: String) {
            if (str.length == length) {
                val current = str.toInt()
                if (current <= maxValue) max = max.coerceAtLeast(current)
                return
            }

            for (index in 0 until length) {
                if (visited[index] || (str == "" && num[index] == '0')) continue
                visited[index] = true
                backtrack(str + num[index])
                visited[index] = false
            }
        }

        backtrack("")
        return max
    }
}

fun main() {
    Baekjoon16943().solve()
}
