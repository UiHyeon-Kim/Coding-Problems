fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val nums = readln().split(" ").map { it.toInt() }.sorted()
    val arr = IntArray(m)
    val sb = StringBuilder()

    fun backtrack(depth: Int) {
        if (depth == m) {
            for (i in arr) { sb.append(i).append(' ') }
            sb.append("\n")
            return
        }

        for (num in nums) {
            arr[depth] = num
            backtrack(depth + 1)
        }
    }
    backtrack(0)
    println(sb)
}
