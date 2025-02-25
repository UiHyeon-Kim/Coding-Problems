fun main() {
    val n = readln().toInt()
    val number = readln().split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()

    for (i in 0..<n) {
        result.add(i - number[i], i + 1)
    }

    println(result.joinToString(" "))
}
