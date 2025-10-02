fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }.sorted()
    val arr = IntArray(m)
    val result = LinkedHashSet<String>()

    fun backtrack(depth: Int, start: Int) {
        if (depth == m) {
            result.add(arr.joinToString(" "))
            return
        }

        for (i in start until n) {
            arr[depth] = nums[i]
            backtrack(depth + 1, i)
        }
    }
    backtrack(0, 0)
    println(result.joinToString("\n"))
}
