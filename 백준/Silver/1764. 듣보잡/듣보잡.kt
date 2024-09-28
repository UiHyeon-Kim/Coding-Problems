fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val listenSee = mutableSetOf<String>()
    val noListenSee = mutableListOf<String>()

    repeat(n) {
        val listen = readln()
        listenSee.add(listen)
    }
    repeat(m) {
        val see = readln()
        val size = listenSee.size
        listenSee.add(see)
        if (size == listenSee.size) noListenSee.add(see)
    }
    noListenSee.sort()
    println(noListenSee.size)
    for (result in noListenSee) println(result)
}