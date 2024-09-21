fun main() {
    val n = readln().toInt()
    repeat(n) {
        val num = readln().let { println("$it $it") }
    }
}