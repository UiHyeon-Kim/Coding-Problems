fun main() {
    val computerCnt = readln().toInt()
    val graph = Array(computerCnt + 1) { mutableListOf<Int>() }

    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }

    val dfsVisited = BooleanArray(computerCnt + 1)
    var dfsCnt = 0
    fun dfs(node: Int) {
        val current = graph[node]
        dfsVisited[node] = true

        for (i in current) {
            if (!dfsVisited[i]){
                dfsCnt++
                dfs(i)
            }
        }
    }

    var bfsCnt = 0
    fun bfs(start: Int) {
        val queue = ArrayDeque<Int>()
        val bfsVisited = BooleanArray(computerCnt + 1)

        queue.add(start)
        bfsVisited[start] = true

        while (queue.isNotEmpty()) {
            val node = queue.removeLast()

            for (i in graph[node]) {
                if (!bfsVisited[i]) {
                    queue.add(i)
                    bfsVisited[i] = true
                    bfsCnt++
                }
            }
        }
    }

    dfs(1)
    println(dfsCnt)

//    bfs(1)
//    println(bfsCnt)
}
