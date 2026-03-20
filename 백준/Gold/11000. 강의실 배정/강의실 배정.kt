import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val lessons = Array(n) {
        val st = StringTokenizer(readLine())
        Lesson(st.nextToken().toInt(), st.nextToken().toInt())
    }.apply {
        sortWith(compareBy({ it.start }, { it.end }))
    }

    val pq = PriorityQueue<Int>()
    pq.add(lessons[0].end)

    for (idx in 1..<n) {
        if (pq.peek() <= lessons[idx].start) {
            pq.poll()
        }

        pq.add(lessons[idx].end)
    }

    println(pq.size)
}

data class Lesson(val start: Int, val end: Int)