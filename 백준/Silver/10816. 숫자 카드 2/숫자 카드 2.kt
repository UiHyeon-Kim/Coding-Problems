fun main() {
    val n = readln().toInt()
    val card = readln().split(" ").map { it.toInt() }.sorted()
    val m = readln().toInt()
    val comparisonTarget = readln().split(" ").map { it.toInt() }
    val result = StringBuilder()

    fun startSearch(target: Int): Int {
        var min = 0
        var max = card.size - 1

        while (min <= max) {
            val mid = (min + max) / 2

            if (card[mid] >= target) max = mid - 1
            else min = mid + 1
        }
        return min
    }

    fun endSearch(target: Int): Int {
        var min = 0
        var max = card.size - 1

        while (min <= max) {
            val mid = (min + max) / 2

            if (card[mid] > target) max = mid - 1
            else min = mid + 1
        }
        return min
    }

    comparisonTarget.forEach { target ->
        result.append(endSearch(target) - startSearch(target)).append(" ")
    }

    println(result)
}
