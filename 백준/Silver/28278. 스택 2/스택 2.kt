import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = readln().toInt()
    var stack = Stack<Int>()

    repeat(n) {
        val x = br.readLine()
        if (x.length > 1) {
            x.split(" ").map { it.toInt() }.let { stack.push(it[1]) }
        } else {
            when(x.toInt()) {
                2 -> if (stack.isNotEmpty()) bw.write(stack.pop().toString()) else bw.write("-1")
                3 -> bw.write(stack.size.toString())
                4 -> if (stack.empty()) bw.write("1") else bw.write("0")
                5 -> if (stack.isNotEmpty()) bw.write(stack.peek().toString()) else bw.write("-1")
            }
            bw.newLine()
            bw.flush()
        }
    }
    br.close()
    bw.flush()
    bw.close()
}