import java.util.*

fun main() {
    val n = readln().toInt()

    println(bfs(n))
}

fun bfs(n: Int): Int {
    val visited = BooleanArray(n + 1)
    val q = ArrayDeque<Pair<Int, Int>>()

    q.offer(n to 0)
    visited[n] = true

    while (q.isNotEmpty()) {
        val (num, cnt) = q.poll()

        if (num == 1) return cnt

        if (num % 3 == 0 && !visited[num / 3]) {
            visited[num / 3] = true
            q.offer(num / 3 to cnt + 1)
        }
        if (num % 2 == 0 && !visited[num / 2]) {
            visited[num / 2] = true
            q.offer(num / 2 to cnt + 1)
        }
        if (num > 1 && !visited[num - 1]) {
            visited[num - 1] = true
            q.offer(num - 1 to cnt + 1)
        }
    }
    return -1
}
