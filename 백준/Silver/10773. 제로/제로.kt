import java.util.*

fun main() {
    val cnt = readln().toInt()
    val stack = Stack<Int>()
    var sum = 0

    repeat(cnt) {
        val number = readln().toInt()
        if (number != 0) stack.push(number)
        else stack.pop()
    }

    repeat(stack.size){
        sum += stack.pop()
    }

    println(sum)
}
