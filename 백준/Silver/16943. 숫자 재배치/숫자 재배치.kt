fun main() {
    val (a, b) = readln().split(" ")
    var maxNum = 0
    val current = mutableListOf<Int>()
    val visited = BooleanArray(a.length)

    if (a.length > b.length || a.all { it.code > b.first().code }) {
        println(-1)
        return
    }

    fun findMaxNum(depth: Int): Int {
        if (depth == a.length) {
            val currentNum = current.joinToString("").toInt()
            if (currentNum <= b.toInt()) {
                maxNum = maxOf(maxNum, currentNum)
            }
            return maxNum
        }

        for (i in a.indices) {
            if (current.size == 0 && a[i] == '0') continue
            if (!visited[i]) {
                current.add(a[i].toString().toInt())
                visited[i] = true
                findMaxNum(depth + 1)
                current.removeLast()
                visited[i] = false
            }
        }

        return -1
    }

    findMaxNum(0)
    println(if (maxNum != 0) maxNum else -1)
}
