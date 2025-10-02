fun main() {
    val n = readln().toInt()
    val routes = Array(n) { readln().split(" ").map { it.toInt() } }
    val visited = BooleanArray(n).apply { this[0] = true }
    var result = Int.MAX_VALUE

    fun backtrack(cost: Int, city: Int, count: Int) {
        if (count == n) {
            if (routes[city][0] > 0) result = minOf(result, cost + routes[city][0])
            return
        }

        for (i in 0 until n) {
            if (visited[i] || routes[city][i] == 0) continue
            visited[i] = true
            backtrack(cost + routes[city][i], i, count + 1)
            visited[i] = false
        }
    }
    backtrack(0, 0, 1)
    println(result)
}