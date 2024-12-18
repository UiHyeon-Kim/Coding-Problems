import java.util.*

fun main() {
    val progression = MutableList(readln().toInt()) { readln().toInt() }
    val stack = Stack<Int>()
    val sb = StringBuilder()
    var trun = 1

    for (currentNum in progression) {
        while (currentNum >= trun) {
            stack.add(trun++)
            sb.append("+\n")
        }
        if (stack.peek() == currentNum) {
            stack.pop()
            sb.append("-\n")
        } else {
            println("NO")
            return
        }
    }

    println(sb)
}
