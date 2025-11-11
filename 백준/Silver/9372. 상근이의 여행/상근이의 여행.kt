// 가중치 없고 모든 국가를 방문... 해야하면 그냥 n - 1

fun main() = repeat(readln().toInt()) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    repeat(m) { readln() }
    println(n - 1)
}