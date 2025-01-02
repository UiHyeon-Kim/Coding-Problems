import java.util.*

fun bfs(start: Int, graph: List<MutableList<Int>>, count: Int) {
    val queue: Queue<Int> = LinkedList()
    val visited = BooleanArray(count + 1)
    val result = IntArray(count + 1)

    queue.offer(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        for (neighbor in graph[node]) {
            if (!visited[neighbor]) {
                queue.offer(neighbor)
                visited[neighbor] = true
                result[neighbor] = node
            }
        }
    }

    for (i in 2..count) {
        println(result[i])
    }
}

fun main() {
    val count = readln().toInt()
    val graph = List(count + 1) { mutableListOf<Int>() }

    repeat(count - 1) {
        val linkedNode = readln().split(" ").map { it.toInt() }
        graph[linkedNode[0]].add(linkedNode[1])
        graph[linkedNode[1]].add(linkedNode[0])
    }

    bfs(1, graph, count)
}
