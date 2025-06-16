fun main() {
    // 큐의 크기, 뽑아내는 수의 개수
    val (n, m) = readln().split(" ").map { it.toInt() }
    val deque = ArrayDeque((1..n).map { it })
    val finds = readln().split(" ").map { it.toInt() }
    var answer = 0

    for (i in 0..<m) {
        val nextIndex = deque.indices.find { deque[it] == finds[i] }!!
        if (nextIndex < deque.size - nextIndex) {
            repeat(nextIndex) {
                deque.addLast(deque.removeFirst())
                answer++
            }
        } else {
            while (finds[i] != deque.first()) {
                deque.addFirst(deque.removeLast())
                answer++
            }
        }
        deque.removeFirst()
    }

    println(answer)
}