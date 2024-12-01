fun main() {
    val arr = MutableList(readln().toInt()) { readln().toInt() }.sorted()
    arr.forEach { println(it) }
}
