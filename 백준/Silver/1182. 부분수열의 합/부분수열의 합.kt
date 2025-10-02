fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }
    val subset = mutableListOf<Int>()
    val result = mutableListOf<Int>()
    val visited = BooleanArray(n + 1)

    fun backtrack(depth: Int, start: Int) {
        if (depth == n) return

        for (i in start..<n) {
            if (visited[i]) continue
            visited[i] = true
            subset.add(nums[i])
            result.add(subset.sum())
            backtrack(depth + 1, i + 1)
            subset.removeLast()
            visited[i] = false
        }
    }
    backtrack(0, 0)
    println(result.count { it == s })
}