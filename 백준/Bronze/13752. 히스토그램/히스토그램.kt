fun main() {
    val cnt = readln().toInt()
    val num = Array(cnt) { readln().toInt().let { println("=".repeat(it)) } }
}