fun main() {
    repeat(readln().toInt()) {
        println(readln().split(" ").joinToString(" ") { it.reversed() })
    }
}