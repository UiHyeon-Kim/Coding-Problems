fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val current = mutableListOf<Int>()
    val sb = StringBuilder()

    fun backTrack(depth: Int) {
        if (depth == m) {
            sb.append(current.joinToString(" ")).append("\n")
            return
        }

        for (i in 1..n) {
            current.add(i)
            backTrack(depth + 1)
            current.removeAt(current.lastIndex)
        }
    }

    backTrack(0)
    println(sb)
}