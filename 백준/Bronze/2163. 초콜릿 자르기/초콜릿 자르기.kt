fun main() {
    val chocoSize = readln().split(" ").map { it.toInt() }
    println(chocoSize[0] * chocoSize[1] - 1)
}