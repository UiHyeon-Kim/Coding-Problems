fun binarySearch(cards: List<Int>, target: Int): Int {
    var low = 0
    var high = cards.size - 1

    while (low <= high) {
        val mid = (low + high) / 2
        when {
            cards[mid] == target -> return 1
            cards[mid] < target -> low = mid + 1
            else -> high = mid - 1
        }
    }
    return 0
}

fun main() {
    val n = readln()
    val cards = readln().split(" ").map { it.toInt() }.sorted()
    val m = readln()
    val search = readln().split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()

    for (target in search) {
        result.add(binarySearch(cards, target))
    }

    println(result.joinToString(" "))
}
