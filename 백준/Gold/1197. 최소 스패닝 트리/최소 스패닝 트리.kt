import java.util.*

data class Edge(val to: Int, val weight: Int)

fun main() {
    val (v, e) = readln().split(" ").map { it.toInt() }
    val graph = Array(v + 1) { mutableListOf<Edge>() }

    repeat(e) {
        val (start, end, weight) = readln().split(" ").map { it.toInt() }
        graph[start].add(Edge(end, weight))
        graph[end].add(Edge(start, weight))
    }

    val pq = PriorityQueue(compareBy<Edge> { it.weight })
    val visited = BooleanArray(v + 1)
    var total = 0
    var count = 0

    pq.add(Edge(1, 0))

    while (pq.isNotEmpty()) {
        val (node, weight) = pq.poll()
        if (visited[node]) continue
        visited[node] = true
        total += weight
        count++

        if (count == v) break

        for (neighbor in graph[node]) {
            if (!visited[neighbor.to]) pq.add(Edge(neighbor.to, neighbor.weight))
        }
    }

    println(total)
}