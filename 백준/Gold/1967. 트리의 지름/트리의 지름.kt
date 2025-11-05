fun main() {
    val n = readln().toInt()
    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }
    val visited = BooleanArray(n + 1)
    var max = 0

    repeat(n - 1) {
        val (node1, node2, weight) = readln().split(" ").map { it.toInt() }
        graph[node1].add(node2 to weight)
        graph[node2].add(node1 to weight)
    }

    fun dfs(next: Int, sum: Int) {
        visited[next] = true

        max = max.coerceAtLeast(sum)

        for ((neighbor, weight) in graph[next]) {
            if (visited[neighbor]) continue
            dfs(neighbor, sum + weight)
        }
    }

    for (i in 1..n) {
        dfs(i, 0)
        visited.fill(false)
    }

    println(max)
}
