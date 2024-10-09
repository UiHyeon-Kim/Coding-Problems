import kotlin.math.sqrt
import kotlin.math.pow

fun main() {
    var cnt = 0

    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toDouble() }
        cnt++

        if (a == 0.0 && b == 0.0 && c == 0.0) break

        println("Triangle #$cnt")
        
        when {
            a == -1.0 -> {
                // c^2 - b^2 = a^2 => a = sqrt(c^2 - b^2)
                if (c > b) {
                    val result = sqrt(c.pow(2) - b.pow(2))
                    println("a = %.3f".format(result))
                } else {
                    println("Impossible.")
                }
            }
            b == -1.0 -> {
                // c^2 - a^2 = b^2 => b = sqrt(c^2 - a^2)
                if (c > a) {
                    val result = sqrt(c.pow(2) - a.pow(2))
                    println("b = %.3f".format(result))
                } else {
                    println("Impossible.")
                }
            }
            c == -1.0 -> {
                // a^2 + b^2 = c^2 => c = sqrt(a^2 + b^2)
                val result = sqrt(a.pow(2) + b.pow(2))
                println("c = %.3f".format(result))
            }
        }
        println()
    }
}
