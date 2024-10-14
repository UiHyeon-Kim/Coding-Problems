import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val queue: Queue<Int> = LinkedList()

    repeat(br.readLine().toInt()) {
        val input = br.readLine().split(" ")

        when(input[0]) {
            "push" -> queue.offer(input[1].toInt())
            "pop" -> if (queue.isNotEmpty()) println(queue.poll()) else println(-1)
            "size" -> println(queue.size)
            "empty" -> println(if (queue.isNotEmpty()) 0 else 1)
            "front" -> println(queue.firstOrNull() ?: -1)
            "back" -> println(queue.lastOrNull() ?: -1)
        }
    }
}