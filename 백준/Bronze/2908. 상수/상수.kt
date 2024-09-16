import kotlin.math.max

fun main() {
    val (A, B) = readln().split(" ")

    val num1 = A.reversed().toInt()
    val num2 = B.reversed().toInt()
    println(max(num1,num2))
}