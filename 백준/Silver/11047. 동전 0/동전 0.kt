fun main() {
    var (n, value) = readln().split(" ").map { it.toInt() }
    val coins = List(n) { readln().toInt() }.sortedDescending()
    var count = 0

    coins.forEach { coin ->
        if (value / coin > 0) {
            count += value / coin
            value = value % coin
        }
    }

    println(count)
}
