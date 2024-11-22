import java.util.*

fun main() {
    val pq = PriorityQueue<Int>()
    val n = readln().toInt()

    repeat(n) {
        when (val x = readln().toInt()) {
            0 -> println(pq.poll() ?: 0)
            else -> pq.offer(x)
        }
    }
}