fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val min = minOf(n, m).let { println(it/2) }
}