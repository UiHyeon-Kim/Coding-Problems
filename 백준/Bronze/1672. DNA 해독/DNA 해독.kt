fun main() {
    val n = readln().toInt()
    val input = readln()
    val base = mapOf(
        'A' to mapOf('A' to 'A', 'G' to 'C', 'C' to 'A', 'T' to 'G'),
        'G' to mapOf('A' to 'C', 'G' to 'G', 'C' to 'T', 'T' to 'A'),
        'C' to mapOf('A' to 'A', 'G' to 'T', 'C' to 'C', 'T' to 'G'),
        'T' to mapOf('A' to 'G', 'G' to 'A', 'C' to 'G', 'T' to 'T'),
    )

    var result = input.last()

    for (i in n - 2 downTo 0) {
        result = base[input[i]]!![result]!!
    }

    println(result)
}