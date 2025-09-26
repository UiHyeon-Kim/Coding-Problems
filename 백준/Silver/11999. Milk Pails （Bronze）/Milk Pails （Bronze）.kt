fun main() {
    val (x, y, m) = readln().split(" ").map { it.toInt() }
    var max = 0

    for (i in 0..m) {
        for (j in 0..m) {
            val sum = i * x + j * y
            if (sum <= m) max = max.coerceAtLeast(sum)
        }
    }

    println(max)
}
