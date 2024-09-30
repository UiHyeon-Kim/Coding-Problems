import kotlin.math.pow

fun main() {
    val input = readln().split(" ").map { it.toFloat() }
    var result = 0.0
    repeat(input.size) {
        result += input[it].pow(2)
    }
    println((result%10).toInt())
}