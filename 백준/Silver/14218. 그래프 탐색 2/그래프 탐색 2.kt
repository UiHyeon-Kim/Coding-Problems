fun main() {
    val (cityCnt, roadCnt) = readln().split(" ").map { it.toInt() }
    val graph = Array(cityCnt + 1) { mutableListOf<Int>() }

    repeat(roadCnt) { linkCity(graph) }

    val maintenance = readln().toInt()
    repeat(maintenance) {
        linkCity(graph)
        val result = bfs(1, cityCnt + 1, graph)

        println((1..cityCnt).joinToString(" ") { result[it].toString() })
    }
}

private fun bfs(start: Int, cnt: Int, graph: Array<MutableList<Int>>): IntArray {
    val q = ArrayDeque<Int>()
    val visited = BooleanArray(cnt)
    val distance = IntArray(cnt) { -1 }

    q.add(start)
    visited[start] = true
    distance[start] = 0

    while (q.isNotEmpty()) {
        val current = q.removeFirst()

        for (next in graph[current]) {
            if (!visited[next]) {
                q.add(next)
                visited[next] = true
                distance[next] = distance[current] + 1
            }
        }
    }

    return distance
}

private fun linkCity(graph: Array<MutableList<Int>>) {
    val (a, b) = readln().trim().split(" ").map { it.toInt() }
    graph[a].add(b)
    graph[b].add(a)
}
