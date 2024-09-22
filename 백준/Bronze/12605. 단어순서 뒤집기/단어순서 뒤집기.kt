import java.util.*

fun main() {
    val cnt = readln().toInt()
    val stack = Stack<String>()

    repeat(cnt) {
        val str = readln().split(" ")

        repeat(str.size){
            stack.push(str[it])
        }
        print("Case #${it+1}:")
        repeat(str.size){
            print(" ${stack.pop()}")
        }
        println()
    }
}