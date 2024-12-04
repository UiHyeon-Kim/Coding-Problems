fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val lightBulb = readln().split(" ").map { it.toInt() }.toMutableList()

    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }

        when (a) {
            1 -> lightBulb[b - 1] = c
            2 -> {
                for (i in b - 1..c - 1) {
                    if (lightBulb[i] == 1) lightBulb[i] = 0
                    else lightBulb[i] = 1
                }
            }

            3 -> {
                for (i in b - 1..c - 1) {
                    lightBulb[i] = 0
                }
            }

            4 -> {
                for (i in b - 1..c - 1) {
                    lightBulb[i] = 1
                }
            }
        }
    }
    println(lightBulb.joinToString(" "))
}
