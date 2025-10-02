fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }.sorted()
    val arr = IntArray(m)
    val visited = BooleanArray(n)
    val result = LinkedHashSet<String>()

    fun backtrack(depth: Int) {
        if (depth == m) {
            result.add(arr.joinToString(" "))
            return
        }

        for (i in nums.indices) {
            if (visited[i]) continue
            visited[i] = true
            arr[depth] = nums[i]
            backtrack(depth + 1)
            visited[i] = false
        }
    }

    backtrack(0)
    println(result.joinToString("\n"))
}