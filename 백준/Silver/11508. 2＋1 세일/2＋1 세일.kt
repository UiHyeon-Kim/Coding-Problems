fun main() {
    val n = readln().toInt()
    val prices = List(n) { readln().toInt() }.sortedDescending()
    var result = 0

    for (i in prices.indices) {
        if (i % 3 == 2) continue
        result += prices[i]
    }

    println(result)
}
