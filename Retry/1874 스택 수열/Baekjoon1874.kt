class Baekjoon1874 {

    private lateinit var number: IntArray
    private lateinit var stack: ArrayDeque<Int>
    private lateinit var operation: StringBuilder

    fun solve() {
        val size = readln().toInt()
        number = IntArray(size) { readln().toInt() }

        if (sequence()) println(operation) else println("NO")
    }

    private fun sequence(): Boolean {
        stack = ArrayDeque()
        operation = StringBuilder()

        var currentNum = 1

        for (target in number) {
            while (target >= currentNum) {
                stack.add(currentNum++)
                operation.append('+').append("\n")
            }

            if (stack.last() == target) {
                stack.removeLast()
                operation.append('-').append("\n")
            } else {
                return false
            }
        }

        return true
    }
}

fun main() {
    Baekjoon1874().solve()
}
