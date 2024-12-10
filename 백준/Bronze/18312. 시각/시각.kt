fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var count = 0

    for (h in 0..n) {
        for (m in 0..59) {
            for (s in 0..59) {
                if (k.digitToChar() in h.toString().padStart(2, '0') ||
                    k.digitToChar() in m.toString().padStart(2, '0') ||
                    k.digitToChar() in s.toString().padStart(2, '0')
                ) count++
            }
        }
    }

    println(count)
}
