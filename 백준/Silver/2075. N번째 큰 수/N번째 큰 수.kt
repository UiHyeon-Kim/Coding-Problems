import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n) {
        val input = readln().split(" ").map { it.toInt() }
        pq.addAll(input)
    }

    repeat(n-1) {
        pq.poll()
    }
    println(pq.poll())
}