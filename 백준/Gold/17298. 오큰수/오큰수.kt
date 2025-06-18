import java.util.Stack

fun main() {
    val n = readln().toInt()
    val nums = readln().split(" ").map { it.toInt() }
    val result = IntArray(n) { -1 }
    val stack = Stack<Int>()

    stack.add(0)

    for (i in 1..<nums.size) {
        while (stack.isNotEmpty() && nums[stack.peek()] < nums[i]) {
            result[stack.pop()] = nums[i]
        }
        stack.add(i)
    }

    println(result.joinToString(" "))
}