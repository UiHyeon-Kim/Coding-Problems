import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val pq = PriorityQueue<Int>()

    repeat(n) { pq.offer(readln().toInt()) }

    var result = 0

    while(pq.size != 1) {
        val new = pq.poll() + pq.poll()
        pq.add(new)
        result += new
    }

    println(result)
}