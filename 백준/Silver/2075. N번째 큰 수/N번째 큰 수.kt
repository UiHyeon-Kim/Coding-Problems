import java.util.*

fun main() {
    val n = readln().toInt()
    val nums = PriorityQueue<Int>()

    nums.addAll(readln().split(" ").map { it.toInt() })

    repeat(n - 1) {
        val input = readln().split(" ").map { it.toInt() }

        input.forEach { i ->
            if (nums.peek() < i) {
                nums.poll()
                nums.add(i)
            }
        }
    }

    println(nums.peek())

}
