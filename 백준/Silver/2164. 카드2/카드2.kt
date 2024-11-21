fun main() {
    val n = readln().toInt()
    val q = ArrayDeque<Int>()

    for (i in 1..n) {
        q.add(i)
    }

    while (q.size > 1) {
        q.removeFirst()
        q.addLast(q.removeFirst())
    }
    println(q[0])
}

