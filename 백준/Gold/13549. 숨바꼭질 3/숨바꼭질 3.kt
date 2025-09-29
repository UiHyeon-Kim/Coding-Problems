fun main() {
    val (start, goal) = readln().split(" ").map { it.toInt() }
    val max = 200_000

    val q = ArrayDeque<Pair<Int, Int>>()    // 위치 to 시간
    val visited = BooleanArray(max + 1)

    q.add(start to 0)
    visited[start] = true

    while (q.isNotEmpty()) {
        val (position, time) = q.removeFirst()

        if (position == goal) {
            println(time)
            break
        }

        val multiply = position * 2
        if (multiply in 0..max && !visited[multiply]) {
            q.add(multiply to time)
            visited[multiply] = true
        }

        val pm = listOf(-1, 1)
        for (i in pm) {
            val next = position + i
            if (next in 0..max && !visited[next]) {
                q.add(next to time + 1)
                visited[next] = true
            }
        }
    }
}
