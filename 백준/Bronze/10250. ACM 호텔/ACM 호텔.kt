import kotlin.math.ceil

fun main() {
    val t = readln().toInt()

    repeat(t) {
        val (h, w, n) = readln().split(" ").map { it.toInt() }

        var roomH = if (n % h == 0) h else n % h
        var roomW = ceil(n.toDouble() / h.toDouble()).toInt().toString().padStart(2, '0')

        println("$roomH$roomW")
    }
}