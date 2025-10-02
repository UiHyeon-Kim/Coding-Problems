fun main() {
    val (_, m) = readln().split(" ").map { it.toInt() }
    val num = readln().split(" ").map { it.toInt() }.sorted()
    val arr = IntArray(m)
    val visited = BooleanArray(num.last() + 1)
    val sb = StringBuilder()

    fun backtrack(depth: Int) {
        if (depth == m) {
            for (i in arr) {
                sb.append(i).append(' ')
            }
            sb.append("\n")
            return
        }

        for (i in num) {
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