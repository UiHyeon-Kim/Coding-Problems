import java.util.*
import kotlin.math.abs

fun main() {
    val pq = PriorityQueue<Int> { a, b ->
        when {
            abs(a) == abs(b) -> a - b
            else -> abs(a) - abs(b)
        }
    }
    val n = readln().toInt()

    repeat(n) {
        when (val x = readln().toInt()) {
            0 -> println(pq.poll() ?: 0)
            else -> pq.offer(x)
        }
    }
}
