fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val train = Array(n + 1) { IntArray(21) }

    repeat(m) {
        val command = readln().split(" ").map { it.toInt() }

        when (command[0]) {
            1 -> {
                val (car, seat) = command[1] to command[2]
                train[car][seat] = 1
            }

            2 -> {
                val (car, seat) = command[1] to command[2]
                train[car][seat] = 0
            }

            3 -> {
                val car = command[1]
                for (i in 19 downTo 1) {
                    train[car][i + 1] = train[car][i]
                }
                train[car][1] = 0
            }

            4 -> {
                val car = command[1]
                for (i in 2..20) {
                    train[car][i - 1] = train[car][i]
                }
                train[car][20] = 0
            }
        }
    }

    val set = mutableSetOf<String>()
    for (i in 1..n) {
        set.add(train[i].joinToString(""))
    }
    println(set.size)
}