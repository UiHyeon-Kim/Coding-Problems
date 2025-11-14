fun main() {
    val (n, w) = readln().split(" ").map { it.toInt() }
    val tree = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1)
    var leafNode = 0

    repeat(n - 1) {
        val (node1, node2) = readln().split(" ").map { it.toInt() }
        tree[node1].add(node2)
        tree[node2].add(node1)
    }

    fun dfs(node: Int) {
        visited[node] = true

        var isLeafNode = true

        for (i in tree[node]) {
            if (!visited[i]) {
                dfs(i)
                isLeafNode = false
            }
        }

        if (isLeafNode) leafNode++
    }


    dfs(1)
    println(w / leafNode.toDouble())
}