fun main() {
    val n = readln().toInt()
    val h = readln().split(" ").map { it.toInt() }.sorted()
    var sum = 0

    for (i in h.indices) {
        var midTotal = 0
        for (j in 0..i) {
            midTotal += h[j]
        }
        sum += midTotal
    }

    println(sum)
}
