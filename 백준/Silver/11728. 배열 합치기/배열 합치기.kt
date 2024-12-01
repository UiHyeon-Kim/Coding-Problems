fun main() {
    val a = readln()
    val list = mutableListOf<Int>()
    repeat(2) {
        val input = readln().split(" ").map { it.toInt() }
        list.addAll(input)
    }
    println(list.sorted().joinToString(" "))
}
