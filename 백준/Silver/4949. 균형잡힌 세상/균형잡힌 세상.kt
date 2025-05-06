import java.util.*

fun main() {
    while (true) {
        val str = readln()
        val stack = Stack<Char>()

        for (char in str) {
            if (str.length == 1 && char == '.') return
            if (char !in listOf('(', ')', '[', ']', '.')) continue

            when (char) {
                '(', '[' -> stack.push(char)
                ')' -> if (stack.isEmpty() || stack.pop() != '(') {
                    println("no")
                    break
                }
                ']' -> if (stack.isEmpty() || stack.pop() != '[') {
                    println("no")
                    break
                }
                '.' -> if (stack.isEmpty()) println("yes") else println("no")
            }
        }
    }
}