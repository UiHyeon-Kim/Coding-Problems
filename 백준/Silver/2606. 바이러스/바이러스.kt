fun dfs(node: Int, network: List<MutableList<Int>>, visited: BooleanArray): Int {
    visited[node] = true
    var cnt = 0

    for (i in network[node]) {
        if (!visited[i]) {
            cnt++
            cnt += dfs(i, network, visited)
        }
    }
    return cnt
}

fun main() {
    val computer = readln().toInt()
    val linkedCom = readln().toInt()
    val network = List(computer + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(computer + 1)

    repeat(linkedCom) {
        val com = readln().split(" ").map { it.toInt() }
        network[com[0]].add(com[1])
        network[com[1]].add(com[0])
    }

    println(dfs(1, network, visited))
}
