fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val human = MutableList(n) { it + 1 }
    val yose = mutableListOf<Int>()
    var cnt = 0
    
    while (human.isNotEmpty()) {
        cnt = (cnt + (k - 1)) % human.size
        yose.add(human.removeAt(cnt))
    }
    println("<${yose.joinToString(separator = ", ")}>")

}