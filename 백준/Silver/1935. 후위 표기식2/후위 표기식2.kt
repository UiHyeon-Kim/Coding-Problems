import java.util.*

fun main() {
    val n = readln().toInt()
    val rawString = readln()
    val nums = mutableListOf<Int>()
    val s = Stack<Double>()

    repeat(n) {
        nums.add(readln().toInt())
    }

    rawString.forEach { c: Char ->
        if (c in 'A'..'Z') {
            s.push(nums[c - 'A'].toDouble())
        } else {
            when (c) {
                '+' -> s.push(s.pop() + s.pop())
                '-' -> {
                    val a = s.pop()
                    val b = s.pop()
                    s.push(b - a)
                }

                '*' -> s.push(s.pop() * s.pop())
                else -> {
                    val a = s.pop()
                    val b = s.pop()
                    s.push(b / a)
                }
            }
        }
    }
    println(String.format("%.2f", s.pop()))

}
