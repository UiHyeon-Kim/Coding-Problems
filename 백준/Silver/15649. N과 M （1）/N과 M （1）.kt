fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val visited = BooleanArray(n + 1)
    val current = mutableListOf<Int>()

    fun backTrack(depth: Int) {
        if (depth == m) {
            println(current.joinToString(" "))
            return
        }

        for (i in 1..n) {
            if (!visited[i]) {
                visited[i] = true
                current.add(i)
                backTrack(depth + 1)
                visited[i] = false
                current.removeAt(current.lastIndex)
            }
        }
    }

    backTrack(0)
}
