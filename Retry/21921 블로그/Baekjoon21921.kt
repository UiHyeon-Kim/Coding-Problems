class Baekjoon21921 {

    private lateinit var date: IntArray

    fun solve() {
        val (today, period) = readln().split(" ").map { it.toInt() }
        date = readln().split(" ").map { it.toInt() }.toIntArray().also { arr ->
            if (arr.all { it == 0 }) {
                println("SAD")
                return
            }
        }

        printMaxAndCount(today, period)
    }

    private fun printMaxAndCount(today: Int, period: Int) {
        var sum = date.take(period).sum()
        var max = sum
        var count = 1

        for (i in 0 until today - period) {
            sum = sum - date[i] + date[i + period]

            if (max == sum) {
                count++
            } else if (max < sum) {
                max = sum
                count = 1
            }
        }

        println(max)
        println(count)
    }
}

fun main() {
    Baekjoon21921().solve()
}
