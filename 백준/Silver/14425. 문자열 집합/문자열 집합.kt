fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val strs = mutableSetOf<String>()
    var count = 0

    repeat(n) { strs.add(readln()) }
    repeat(m) {
        if (readln() in strs) count++
    }
    println(count)
}
