import java.util.*

fun main() {
    val computer = readln().toInt()
    val linkCom = readln().toInt()
    val graph = Array(computer + 1) { mutableListOf<Int>() }

    repeat(linkCom) {
        val com = readln().split(" ").map { it.toInt() }
        graph[com[0]].add(com[1])
        graph[com[1]].add(com[0])
    }
    println(bfs(computer, graph))
}

fun bfs(computer: Int, graph: Array<MutableList<Int>>): Int {
    val visited = BooleanArray(computer + 1)
    val queue: Queue<Int> = LinkedList()
    var ans = 0

    queue.offer(1)
    visited[1] = true

    while (queue.isNotEmpty()) {
        val node = queue.poll()

        for (neighbor in graph[node]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true
                queue.add(neighbor)
                ans++
            }
        }
    }
    return ans
}