fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }.sorted()
    val arr = IntArray(m)
    val sb = StringBuilder()

    fun backtrack(depth: Int, start: Int) {
        if (depth == m) {
            for (i in arr) { sb.append(i).append(' ') }
            sb.append("\n")
            return
        }

        for (i in start..<nums.size) {
            arr[depth] = nums[i]
            backtrack(depth + 1, i)
        }
    }
    backtrack(0, 0)
    println(sb)
}