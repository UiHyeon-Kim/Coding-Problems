import java.math.BigInteger

fun main() {
    val n = readln().toInt()
    val fibonacci = mutableListOf<BigInteger>()

    fibonacci.add("0".toBigInteger())
    fibonacci.add("1".toBigInteger())

    for (i in 2..<n + 1) {
        fibonacci.add(fibonacci[i - 1] + fibonacci[i - 2])
    }

    println(fibonacci[n])
}
