fun main() {
    val (n, q) = readln().split(" ").map { it.toInt() }
    val visited = mutableSetOf<Int>()
    var min = Int.MAX_VALUE

    fun dfs(node: Int) {
        if (node in visited) min = node
        if (node == 1) return

        if (node % 2 == 0) dfs(node / 2)
        else dfs((node - 1) / 2)
    }

    repeat(q) {
        val target = readln().toInt()
        min = Int.MAX_VALUE

        dfs(target)
        visited.add(target)
        println(if (min == Int.MAX_VALUE) 0 else min)
    }
}