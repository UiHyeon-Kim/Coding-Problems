import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val stack = Stack<Int>()

    repeat(br.readLine().toInt()) {
        val input = br.readLine().split(" ")

        when(input[0]){
            "push" -> stack.push(input[1].toInt())
            "pop" -> println(if (stack.isNotEmpty()) stack.pop() else -1)
            "size" -> println(stack.size)
            "empty" -> println(if (stack.isEmpty()) 1 else 0)
            "top" -> println(if (stack.isEmpty()) -1 else stack.peek())
        }
    }
    br.close()
}