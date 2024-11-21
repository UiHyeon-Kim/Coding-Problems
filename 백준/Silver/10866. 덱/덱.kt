fun main() {
    val n = readln().toInt()
    val dec = ArrayDeque<Int>()

    repeat(n) {
        val commend = readln().split(" ")

        when (commend[0]) {
            "push_front" -> dec.addFirst(commend[1].toInt())
            "push_back" -> dec.addLast(commend[1].toInt())
            "pop_front" -> println(dec.removeFirstOrNull() ?: -1)
            "pop_back" -> println(dec.removeLastOrNull() ?: -1)
            "size" -> println(dec.size)
            "empty" -> println(if (dec.isEmpty()) 1 else 0)
            "front" -> println(dec.firstOrNull() ?: -1)
            "back" -> println(dec.lastOrNull() ?: -1)
        }
    }
}