fun main() {
    val (a1, a0) = readln().split(" ").map { it.toInt() }
    val (c1, c2) = readln().split(" ").map { it.toInt() }
    val n0 = readln().toInt()

    var isValid = true

    for (n in n0..101) {
        val fn = a1 * n + a0
        if (fn !in (c1 * n)..(c2 * n)) {
            isValid = false
            break
        }
    }

    print(if (isValid) 1 else 0)
}
