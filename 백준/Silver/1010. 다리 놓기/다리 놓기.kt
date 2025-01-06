fun main() {
    repeat(readln().toInt()) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        println(combination(m, n))
    }
}

fun combination(m: Int, n: Int): Long {
    var result: Long = 1
    for (i in 0..<n) {
        result = result * (m - i) / (i + 1)
    }
    return result

}

