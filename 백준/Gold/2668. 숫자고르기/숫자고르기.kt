fun main() {
    val n = readln().toInt()
    val nums = IntArray(n + 1)
    val visited = BooleanArray(n + 1)
    val path = mutableSetOf<Int>()
    val result = mutableSetOf<Int>()

    repeat(n) { nums[it + 1] = readln().toInt() }

    fun dfs(start: Int, current: Int) {
        if (visited[current]) return

        visited[current] = true
        path.add(current)

        if (!visited[nums[current]]) {
            dfs(start, nums[current])
        } else if (start == nums[current]) {
            result += path
        }
    }

    for (i in 1..n) {
        dfs(i, i)
        visited.fill(false)
        path.clear()
    }

    println(result.size)
    for (i in result.sorted()) {
        println(i)
    }
}