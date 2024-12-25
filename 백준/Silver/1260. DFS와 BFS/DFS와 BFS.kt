import java.util.*

fun dfs(node: Int, graph: List<MutableList<Int>>, visited: BooleanArray) {
    visited[node] = true
    print("$node ")

    for (neighbor in graph[node]) {
        if (!visited[neighbor]) {
            dfs(neighbor, graph, visited)
        }
    }
}

fun bfs(start: Int, graph: List<MutableList<Int>>, i: Int) {
    val q: Queue<Int> = LinkedList()
    val visited = BooleanArray(i + 1)

    q.offer(start)
    visited[start] = true

    while (q.isNotEmpty()) {
        val node = q.poll()
        print("$node ")
        for (neighbor in graph[node]) {
            if (!visited[neighbor]) {
                q.offer(neighbor)
                visited[neighbor] = true
            }
        }
    }
}

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val graph = List(input[0] + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(input[0] + 1)

    repeat(input[1]) {
        val node = readln().split(" ").map { it.toInt() }
        graph[node[0]].add(node[1])
        graph[node[1]].add(node[0])
    }

    repeat(input[0] + 1) { graph[it].sort() }

    dfs(input[2], graph, visited)
    println()
    bfs(input[2], graph, input[0])
}
