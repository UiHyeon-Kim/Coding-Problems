fun main() {
    val n = readln().toLong()
    var result: Long = 1

    for (i in 1..n) {
        result *= i
    }

    println(result)
}
