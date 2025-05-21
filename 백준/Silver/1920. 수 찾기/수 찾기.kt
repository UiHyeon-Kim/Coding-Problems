fun main() {
    readln()
    val cards = readln().split(" ").map { it.toInt() }.toSet()
    readln()
    val search = readln().split(" ").map { it.toInt() }

    println(search.joinToString("\n") { if (it in cards) "1" else "0" })
}