fun main() {
    val arr = MutableList(28) { readln().toInt() }.sorted()
    for (i in 1..30) {
        if (i !in arr) println(i)
    }
}
