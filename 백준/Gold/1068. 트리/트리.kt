fun main() {
    val n = readln().toInt()
    val parents = readln().split(" ").map { it.toInt() }
    val removeNode = readln().toInt()
    val tree = Array(n) { mutableListOf<Int>() }

    val rootNode = parents.indexOf(-1)
    var leafNode = 0

    if (removeNode == rootNode) {
        println(0)
        return
    }

    for (i in 0 until n) {
        if (parents[i] != -1) tree[parents[i]].add(i)
    }

    tree.forEach { it.remove(removeNode) }


    fun dfs(node: Int) {
        if (tree[node].isEmpty()) leafNode++

        for (i in tree[node]) {
            dfs(i)
        }
    }

    dfs(rootNode)
    println(leafNode)
}
