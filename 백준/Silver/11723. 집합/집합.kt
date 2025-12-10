import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val count = readLine().toInt()
    val sb = StringBuilder()
    var mask = 0

    repeat(count) {
        val st = StringTokenizer(readLine())

        when (st.nextToken()) {
            "add" -> {
                val num = 1 shl st.nextToken().toInt()
                mask = mask or (1 shl num)
            }

            "remove" -> {
                val num = 1 shl st.nextToken().toInt()
                mask = mask and (1 shl num).inv()
            }

            "check" -> {
                val num = 1 shl st.nextToken().toInt()
                sb.append(if (mask and (1 shl num) != 0) 1 else 0).append("\n")
            }

            "toggle" -> {
                val num = 1 shl st.nextToken().toInt()
                mask = if (mask and (1 shl num) != 0) mask and (1 shl num).inv() else mask or (1 shl num)
            }

            "all" -> {
                mask = mask or (1 shl 20).inv()
            }

            "empty" -> {
                mask = 0
            }
        }
    }

    println(sb)
}