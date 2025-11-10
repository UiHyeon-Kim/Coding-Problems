data class Edge(
    val to: Int,
    val weight: Int
)

fun main() {
    val (n, root) = readln().split(" ").map { it.toInt() }
    val tree = Array(n + 1) { mutableListOf<Edge>() }

    repeat(n - 1) {
        val (node1, node2, weight) = readln().split(" ").map { it.toInt() }
        tree[node1].add(Edge(node2, weight))
        tree[node2].add(Edge(node1, weight))
    }

    var pillar = 0
    var branch = 0
    var gigaNode = root
    var parent = 0

    while (true) {
        var childCnt = 0

        for (node in tree[gigaNode]) {
            if (node.to != parent) childCnt++
        }

        if (childCnt == 0 || childCnt >= 2) break

        var next = 0
        var weight = 0

        for (node in tree[gigaNode]) {
            if (node.to != parent) {
                next = node.to
                weight = node.weight
                break
            }
        }

        pillar += weight
        parent = gigaNode
        gigaNode = next
    }

    fun dfs(node: Int, parent: Int, weight: Int) {
        var isLeaf = true

        for (next in tree[node]) {
            if (next.to == parent) continue
            isLeaf = false
            dfs(next.to, node, weight + next.weight)
        }

        if (isLeaf) {
            branch = kotlin.math.max(branch, weight)
        }
    }

    dfs(gigaNode, parent, 0)

    println("$pillar $branch")
}