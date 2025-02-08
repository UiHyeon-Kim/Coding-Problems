import java.util.*

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val visited = BooleanArray(100001)
    val q = LinkedList<Pair<Int, Int>>()

    if (n == k) {
        println(0)
        return
    }

    q.add(n to 0)
    visited[n] = true

    while (q.isNotEmpty()) {
        val (loc, time) = q.poll()

        for (next in listOf(loc - 1, loc + 1, loc * 2)) {
            if (next == k) {
                println(time + 1)
                return
            }

            if (next in 0..100000 && !visited[next]) {
                visited[next] = true
                q.add(next to time + 1)
            }
        }
    }
}
