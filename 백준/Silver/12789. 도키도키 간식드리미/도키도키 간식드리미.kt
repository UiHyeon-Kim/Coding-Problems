import java.util.*

fun main() {
    val cnt = readln().toInt()
    val lineStack = Stack<Int>()
    val oneStack = Stack<Int>()
    var sequence = 1

    val nums = readln().split(" ").map { it.toInt() }.reversed().let { lineStack.addAll(it) }

    while (true) {

        if (lineStack.empty() && oneStack.empty()) break

        if (lineStack.isNotEmpty() && lineStack.peek() == sequence){
            lineStack.pop()
            sequence++
        } else if (oneStack.isNotEmpty() && oneStack.peek() == sequence) {
            oneStack.pop()
            sequence++
        } else if (lineStack.empty() && oneStack.isNotEmpty() && oneStack.peek() != sequence) break
        else oneStack.push(lineStack.pop())
    }

    if (lineStack.empty() && oneStack.empty()) println("Nice")
    else println("Sad")
}
