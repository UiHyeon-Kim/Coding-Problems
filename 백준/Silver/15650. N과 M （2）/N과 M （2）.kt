fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val current = mutableListOf<Int>()
    val sb = StringBuilder()

    fun backTrack(start: Int) {
        if (current.size == m) {
            sb.append(current.joinToString(" ")).append("\n")
            return
        }

        for (i in start..n) {
            current.add(i)
            backTrack(i + 1)
            current.removeAt(current.size - 1)
        }
    }

    backTrack(1)
    println(sb)
}