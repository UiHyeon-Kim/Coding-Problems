fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var result: Long = 1
    repeat(k) { result = result * (n - it) / (it + 1) }
    println(result)
}

