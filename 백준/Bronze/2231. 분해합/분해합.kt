fun main() {
    val n = readln().toInt()
    var result = 0

    for (m in (n - 9 * n.toString().length).coerceAtLeast(1)..<n) {
        val constructor = m + m.toString().sumOf { it.toString().toInt() }
        if (constructor == n) {
            result = m
            break
        }
    }

    println(result)
}
