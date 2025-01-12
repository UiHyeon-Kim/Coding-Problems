fun main() {
    val (num1, num2) = readln().split(" ").map { it.toInt() }
    println(gcd(num1, num2))
    println(lcm(num1, num2))
}

fun gcd(num1: Int, num2: Int): Int = if (num2 == 0) num1 else gcd(num2, num1 % num2)
fun lcm(num1: Int, num2: Int): Int = num1 * num2 / gcd(num1, num2)
