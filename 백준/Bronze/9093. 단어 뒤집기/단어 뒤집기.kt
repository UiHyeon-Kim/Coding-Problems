fun main() {
    repeat(readln().toInt()) {
        val str = readln().split(" ").map { it.reversed() }
        println(str.joinToString(" "))
    }
}