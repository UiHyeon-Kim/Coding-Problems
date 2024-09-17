fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val x = readln().split(" ").map { it.toInt() }.toIntArray()

    x.sortDescending()
    println(x[input[1]-1])
}