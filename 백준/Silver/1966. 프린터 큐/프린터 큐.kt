import java.util.*

fun main() {
    val t = readln().toInt()

    repeat(t) {
        var (n, m) = readln().split(" ").map { it.toInt() }
        val document = readln().split(" ").map { it.toInt() }
        val priorityDocument = document.sortedDescending().toMutableList()
        val q: Queue<Int> = LinkedList()
        var count = 1

        q.addAll(document)
        while (q.isNotEmpty()) {
            if (priorityDocument.first() == q.peek()) { // 우선 순위가 맞으면
                q.poll()
                priorityDocument.removeFirst()
                if (m == 0) break
                count++
            } else { // 우선 순위가 안맞으면
                q.offer(q.poll()) // 맨 뒤로 이동
            }
            m--
            if (m == -1) m += q.size
        }
        println(count)
    }
}
