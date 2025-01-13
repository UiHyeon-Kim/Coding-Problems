fun main() {
    val n = readln()
    val cards = readln().split(" ").map { it.toInt() }.toSet()
    val m = readln()
    val search = readln().split(" ").map { it.toInt() }

    val result = search.map { if (it in cards) 1 else 0 }

    println(result.joinToString(" "))
}
