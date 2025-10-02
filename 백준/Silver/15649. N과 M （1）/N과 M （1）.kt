fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(m)
    val visited = BooleanArray(n + 1)
    val sb = StringBuilder(100_000)

    fun backtrack(depth: Int) {
        if ((depth) == m) {
            for (i in arr) {
                sb.append(i).append(' ')
            }
            sb.append("\n")
            return
        }

        for (i in 1..n) {
            if (visited[i]) continue
            visited[i] = true
            arr[depth] = i
            backtrack(depth + 1)
            visited[i] = false
        }
    }

    backtrack(0)
    println(sb)
}