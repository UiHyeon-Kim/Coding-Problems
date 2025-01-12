fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    println(combination(n, k))
}

fun combination(n: Int, k: Int): Long {
    var result: Long = 1
    for (i in 0..<k) {
        result = result * (n - i) / (i + 1)
    }
    return result

}
