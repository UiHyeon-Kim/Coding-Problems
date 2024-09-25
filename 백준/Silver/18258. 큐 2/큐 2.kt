import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val q = LinkedList<Int>()

    repeat(n) {
        val command = br.readLine()

        when {
            command == ("pop") -> {
                sb.append(q.poll() ?: -1).append("\n")
            }
            command == ("size") -> {
                sb.append(q.size).append("\n")
            }
            command == ("empty") -> {
                sb.append(if(q.isEmpty()) 1 else 0).append("\n")
            }
            command == ("front") -> {
                sb.append(q.firstOrNull() ?: -1).append("\n")
            }
            command == ("back") -> {
                sb.append(q.lastOrNull() ?: -1).append("\n")
            }
            else -> q.add(command.split(" ")[1].toInt())
        }
    }
    br.close()
    println(sb.toString())
}