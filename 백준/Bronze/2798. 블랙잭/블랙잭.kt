fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val cards = readln().split(" ").map { it.toInt() }.sorted()
    var result = 0

    for (i in cards.indices - 1) {
        for (j in i + 1..<cards.size - 1) {
            for (k in j + 1..<cards.size) {
                val sum = cards[i] + cards[j] + cards[k]
                if (sum in (result + 1)..m) {
                    result = sum
                }
            }
        }
    }
    println(result)
}
