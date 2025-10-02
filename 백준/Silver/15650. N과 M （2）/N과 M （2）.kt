fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(m)
    val sb = StringBuilder()

    fun backtrack(depth: Int, start: Int) {
        if (depth == m) {
            for (i in arr) { sb.append(i).append(' ') }
            sb.append("\n")
            return
        }

        for (i in start..n) {
            arr[depth] = i
            backtrack(depth + 1, i + 1)
        }
    }
    backtrack(0, 1)
    println(sb)
}